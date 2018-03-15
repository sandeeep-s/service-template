package com.gefa.ekf.boundary.inbound.rest.activities;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gefa.ekf.application.AssetService;
import com.gefa.ekf.application.domain.Asset;
import com.gefa.ekf.application.exceptions.AssetRemovalException;
import com.gefa.ekf.boundary.inbound.rest.representations.AssetRepresentation;

@ApplicationScoped
public class RemoveAssetActivity {

	@Inject
	private AssetService assetService;

	public AssetRepresentation delete(Long assetId) throws AssetRemovalException {

		Asset asset = assetService.removeAsset(assetId);
		

		return new AssetRepresentation(asset);
	}

}
