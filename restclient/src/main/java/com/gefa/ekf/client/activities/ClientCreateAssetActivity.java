package com.gefa.ekf.client.activities;

import java.net.URI;

import com.gefa.ekf.client.domain.Asset;
import com.gefa.ekf.client.exceptions.MalformedAssetException;
import com.gefa.ekf.client.exceptions.ServiceFailureException;
import com.gefa.ekf.client.representations.AssetRepresentation;
import com.gefa.ekf.client.representations.converters.AssetConverter;

public class ClientCreateAssetActivity extends Activity {

	private Asset asset;

	private AssetConverter assetConverter;

	public void createAsset(Asset asset, URI assetURI) {

		try {
			AssetRepresentation assetRepresentation = httpBinding.createAsset(assetConverter.fromAsset(asset), assetURI);
			this.asset = assetConverter.toAsset(assetRepresentation);
			this.actions = new RepresentationHypermediaProcessor()
					.extractNextActionsFromAssetRepresentation(assetRepresentation);

		} catch (MalformedAssetException e) {
			e.printStackTrace();
		} catch (ServiceFailureException e) {
			e.printStackTrace();
		}

	}

	public Asset getAsset() {
		return asset;
	}

}
