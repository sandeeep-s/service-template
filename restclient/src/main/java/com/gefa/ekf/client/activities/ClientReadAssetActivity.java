package com.gefa.ekf.client.activities;

import java.net.URI;

import com.gefa.ekf.client.domain.Asset;
import com.gefa.ekf.client.exceptions.NotFoundException;
import com.gefa.ekf.client.exceptions.ServiceFailureException;
import com.gefa.ekf.client.representations.AssetRepresentation;
import com.gefa.ekf.client.representations.converters.AssetConverter;

public class ClientReadAssetActivity extends Activity {

	private final URI assetURI;
	private Asset asset;
	private AssetConverter assetConverter;

	public ClientReadAssetActivity(URI assetURI) {
		this.assetURI = assetURI;
	}

	public void readAsset() throws NotFoundException, ServiceFailureException {
			AssetRepresentation assetRepresentation = httpBinding.retrieveAsset(assetURI);
			this.asset = assetConverter.toAsset(assetRepresentation);
			this.actions = new RepresentationHypermediaProcessor()
					.extractNextActionsFromAssetRepresentation(assetRepresentation);
	}
	
	public Asset getAsset() {
		return asset;
	}
}
