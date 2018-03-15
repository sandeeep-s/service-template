package com.gefa.ekf.application.domain.repositories;

import java.util.List;

import com.gefa.ekf.application.domain.Asset;

public interface AssetRepository {

	public Long saveAsset(Asset asset);

	public void updateAsset(Asset asset);

	public Asset getAsset(Long assetId);

	public Boolean exists(Long assetNumber);

	public List<Asset> getAssetsByDealer(Long gevisNumber);
}
