package com.gefa.ekf.application.domain.events.handlers;

import com.gefa.ekf.application.domain.events.DomainEvent;

public interface DomainEventHandler {

	public void handle(DomainEvent domainEvent);

}
