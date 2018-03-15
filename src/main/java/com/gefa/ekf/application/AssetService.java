package com.gefa.ekf.application;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gefa.ekf.application.domain.Asset;
import com.gefa.ekf.application.domain.AssetCreatedState;
import com.gefa.ekf.application.domain.events.AssetCreatedEvent;
import com.gefa.ekf.application.domain.events.DomainEvent;
import com.gefa.ekf.application.domain.repositories.MapAssetRepository;
import com.gefa.ekf.application.exceptions.AssetRemovalException;
import com.gefa.ekf.application.infrastructure.DomainEventsDispatcher;

@ApplicationScoped
public class AssetService {

	@Inject
	private MapAssetRepository assetRepository;
	// private AssetRepository assetRepository;

	@Inject
	private DomainEventsDispatcher domainEventsDispatcher;

	public Long create(Asset asset) {
		asset.setAssetState(new AssetCreatedState(asset));
		asset.addDomainEvent(new AssetCreatedEvent(asset));
		for (DomainEvent domainEvent : asset.getDomainEvents()) {
			domainEventsDispatcher.dispatch(domainEvent);
		}
		return assetRepository.saveAsset(asset);
	}

	public void update(Asset asset) {
		Asset assetFromRepo = assetRepository.getAsset(asset.getId());
		assetFromRepo.moveToCreatedState();

		// TODO Update the assetFromRepo details onto asset
		assetRepository.updateAsset(asset);
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
