package com.gefa.ekf.application;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gefa.ekf.application.domain.Asset;
import com.gefa.ekf.application.domain.AssetCreatedState;
import com.gefa.ekf.application.domain.events.AssetCreatedEvent;
import com.gefa.ekf.application.domain.events.DomainEvent;
import com.gefa.ekf.application.domain.repositories.MapAssetRepository;
import com.gefa.ekf.application.exceptions.AssetCreationException;
import com.gefa.ekf.application.exceptions.AssetRemovalException;
import com.gefa.ekf.application.exceptions.AssetUpdateException;
import com.gefa.ekf.application.infrastructure.DomainEventsDispatcher;

@ApplicationScoped
public class AssetService {

    @Inject
    private MapAssetRepository assetRepository;
    // private AssetRepository assetRepository;

    @Inject
    private DomainEventsDispatcher domainEventsDispatcher;

    public Long create(Asset asset) {

        Long assetId;
        try {
            asset.setAssetState(new AssetCreatedState(asset));
            assetId = assetRepository.saveAsset(asset);
            asset.addDomainEvent(new AssetCreatedEvent(asset));
            for (DomainEvent domainEvent : asset.getDomainEvents()) {
                domainEventsDispatcher.dispatch(domainEvent);
            }
        } catch (Exception e) {
            throw new AssetCreationException();
        }

        return assetId;
    }

    public void update(Asset asset) {

        try{
            Asset assetFromRepo = assetRepository.getAsset(asset.getId());
            assetFromRepo.moveToCreatedState();
            assetRepository.updateAsset(asset);

        }catch(UnsupportedOperationException e){
            throw new AssetUpdateException();
        }catch(Exception e){
            throw new AssetUpdateException();
        }

        // TODO Update the assetFromRepo details onto asset
    }

    public Asset getAsset(Long assetId) {
        return assetRepository.getAsset(assetId);
    }

    public Asset removeAsset(Long assetId) {
        try {
            Asset asset = assetRepository.getAsset(assetId);
            asset.moveToDeletedState();
            return assetRepository.delete(assetId);
        } catch (UnsupportedOperationException e) {
            throw new AssetRemovalException();
        }

    }

}
