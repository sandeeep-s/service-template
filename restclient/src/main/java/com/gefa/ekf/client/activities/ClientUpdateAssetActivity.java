package com.gefa.ekf.client.activities;

import java.net.URI;

import com.gefa.ekf.client.domain.Asset;
import com.gefa.ekf.client.exceptions.CannotUpdateAssetException;
import com.gefa.ekf.client.exceptions.MalformedAssetException;
import com.gefa.ekf.client.exceptions.NotFoundException;
import com.gefa.ekf.client.exceptions.ServiceFailureException;
import com.gefa.ekf.client.representations.AssetRepresentation;
import com.gefa.ekf.client.representations.converters.AssetConverter;

public class ClientUpdateAssetActivity extends Activity {

	private final URI assetURI;

	private Asset asset;

	private AssetConverter assetConverter;

	public ClientUpdateAssetActivity(URI assetURI) {
		this.assetURI = assetURI;
	}

	public void updateAsset(Asset asset) {
		try {
			AssetRepresentation assetRepresentation = httpBinding.updateAsset(assetConverter.fromAsset(asset), assetURI);
			this.asset = assetConverter.toAsset(assetRepresentation);
			this.actions = new RepresentationHypermediaProcessor()
					.extractNextActionsFromAssetRepresentation(assetRepresentation);
		} catch (MalformedAssetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotUpdateAssetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Asset getAsset() {
		return asset;
	}

}
