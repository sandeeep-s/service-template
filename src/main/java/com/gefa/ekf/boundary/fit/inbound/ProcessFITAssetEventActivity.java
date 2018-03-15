package com.gefa.ekf.boundary.fit.inbound;

import com.gefa.ekf.application.AssetService;
import com.gefa.ekf.application.domain.Asset;
import com.gefa.ekf.application.domain.repositories.AssetRepository;
import com.gefa.ekf.boundary.fit.domain.FITAssetEvent;

public class ProcessFITAssetEventActivity {

	private AssetService assetService;

	private AssetRepository assetRepository;

	public void create(FITAssetEvent fitAssetEvent) {

		if (assetRepository.exists(fitAssetEvent.getAssetNumber())) {
			Asset asset = assetRepository.getAsset(fitAssetEvent.getAssetNumber());
			assetService.update(asset);
		} else {
			assetService.create(createAssetFromEvent(fitAssetEvent));
		}
	}

	private Asset createAssetFromEvent(FITAssetEvent fitAssetEvent) {
		return new Asset(fitAssetEvent.getAssetName());
	}

	private Asset updateAssetFromEvent(Asset asset, FITAssetEvent fitAssetEvent) {
		return asset;
	}
}
