package com.gefa.ekf.client.representations.converters;


import com.gefa.ekf.client.domain.Asset;
import com.gefa.ekf.client.representations.AssetRepresentation;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AssetConverter {

    public Asset toAsset(AssetRepresentation assetRepresentation) {

        return new Asset(assetRepresentation.getId(),
                assetRepresentation.getAssetName());

    }

    public Asset toAsset(AssetRepresentation assetRepresentation, Long assetId) {
        return new Asset(assetId, assetRepresentation.getAssetName());

    }

    public AssetRepresentation fromAsset(Asset asset) {

        return new AssetRepresentation(asset);
    }

}
