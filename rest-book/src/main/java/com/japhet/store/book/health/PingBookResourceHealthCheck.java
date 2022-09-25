package com.japhet.store.book.health;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.japhet.store.book.BookResource;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
@ApplicationScoped
public class PingBookResourceHealthCheck implements HealthCheck {

	@Inject
	BookResource bookResource;

	@Override
	public HealthCheckResponse call() {
		bookResource.hello();
		return HealthCheckResponse.named("Ping Book REST Endpoint").up()
				.build();
	}
}
