package com.japhet.store.number.health;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.japhet.store.number.NumberResource;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
@ApplicationScoped
public class PingNumberResourceHealthCheck implements HealthCheck {

	@Inject
	NumberResource numberResource;

	@Override
	public HealthCheckResponse call() {
		numberResource.hello();
		return HealthCheckResponse
				.named("Ping Number REST Endpoint")
				.up()
				.build();
	}

}
