package com.gefa.ekf.boundary.outbound.async.fit;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gefa.ekf.application.domain.events.AssetCreatedEvent;

@ApplicationScoped
public class FITAssetService {

	@Inject
	private FITAssetServiceAdapter fitAssetServiceAdapter;

	public void createAsset(AssetCreatedEvent assetCreatedEvent) {
		fitAssetServiceAdapter.createAsset(assetCreatedEvent);
	}

	public void updateAsset(AssetCreatedEvent assetCreatedEvent) {
		fitAssetServiceAdapter.updateAsset(assetCreatedEvent);
	}

}
