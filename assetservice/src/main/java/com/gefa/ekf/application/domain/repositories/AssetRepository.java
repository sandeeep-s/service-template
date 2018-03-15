package com.gefa.ekf.application.domain.repositories;

import java.util.List;

import com.gefa.ekf.application.domain.Asset;

public interface AssetRepository {

	Long saveAsset(Asset asset);

	void updateAsset(Asset asset);

	Asset getAsset(Long assetId);

	Boolean exists(Long assetNumber);

	List<Asset> getAssetsByDealer(Long gevisNumber);
}
