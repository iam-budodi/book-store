package com.japhet.store.number;

import java.time.Instant;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//import com.github.javafaker.Faker;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.faulttolerance.Timeout;
import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import io.quarkus.runtime.annotations.RegisterForReflection;
import net.datafaker.Faker;
import net.datafaker.service.FakeValuesService;
import net.datafaker.service.RandomService;

@Path("/api/numbers")
@RegisterForReflection
@Tag(name = "Number Endpoint")
public class NumberResource {

	@Inject
	Logger LOGGER;

	@ConfigProperty(name = "number.separator", defaultValue = "false")
	boolean separator;

	@ConfigProperty(name = "seconds.sleep", defaultValue = "0")
	int secondsToSleep = 0;

	@Operation(
			summary = "Generates book numbers",
			description = "These book numbers have several formats: ISBN, ASIN and EAN"
	)
	@APIResponse(
			responseCode = "200", content = @Content(
					mediaType = MediaType.APPLICATION_JSON, schema = @Schema(
							implementation = BookNumbers.class
					)
			)
	)

	@Counted(
			name = "countGenerateBookNumber",
			description = "Counts how many times the generateBookNumbers method has been invoked"
	)
	@Timed(
			name = "timeGenerateBookNumber",
			description = "Times how long it takes to invoke the generateBookNumbers method",
			unit = MetricUnits.MILLISECONDS
	)
	@Timeout(10000) // dont work as expected
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response generateBookNumbers() throws InterruptedException {
		LOGGER.info("Waiting for " + secondsToSleep + " seconds");
		TimeUnit.SECONDS.sleep(secondsToSleep);
		LOGGER.info("Generating book numbers");
		Faker faker = new Faker(new Locale("en-GB"), new RandomService());
		
//		FakeValuesService fakeValuesService = new FakeValuesService(
//			      new Locale("en-GB"), new RandomService());
//		fakeValuesService.regexify("");
//		fakeValuesService.
		
		BookNumbers bookNumbers = new BookNumbers();
		bookNumbers.setIsbn10(faker.code().isbn10(separator));
		bookNumbers.setIsbn13(faker.code().isbn13(separator));
//		bookNumbers.setAsin(faker.code().asin());
		bookNumbers.setEan8(faker.code().ean8());
		bookNumbers.setEan13(faker.code().ean13());
		bookNumbers.setGenerationDate(Instant.now());
		return Response.ok(bookNumbers).build();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/ping")
	public String hello() {
		return "hello";
	}
}