package com.gefa.ekf.boundary.fit.outbound;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.gefa.ekf.application.domain.events.AssetCreatedEvent;
import com.gefa.ekf.application.domain.events.DomainEvent;
import com.gefa.ekf.application.domain.events.handlers.DomainEventHandler;

@ApplicationScoped
public class FITAssetCreatedEventHandler implements DomainEventHandler {

	@Inject
	private FITAssetService fitAssetService;

	@Override
	public void handle(DomainEvent assetCreatedEvent) {

			fitAssetService.createAsset((AssetCreatedEvent)assetCreatedEvent);
	}

}
