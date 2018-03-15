package com.gefa.ekf.rest.representations.converters;

import javax.enterprise.context.ApplicationScoped;

import com.gefa.ekf.application.domain.Asset;
import com.gefa.ekf.rest.representations.AssetRepresentation;
import com.gefa.ekf.rest.representations.Link;

@ApplicationScoped
public class AssetConverter {

	public Asset toAsset(AssetRepresentation assetRepresentation) {

		return new Asset(assetRepresentation.getId(),
				assetRepresentation.getAssetName());

	}

	public Asset toAsset(AssetRepresentation assetRepresentation, Long assetId) {
		return new Asset(assetId, assetRepresentation.getAssetName());

	}

	public AssetRepresentation fromAsset(Asset asset, Link... links) {
		return new AssetRepresentation(asset, links);
	}

}
