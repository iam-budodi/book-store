package com.japhet.store.number;

import java.time.Instant;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.github.javafaker.Faker;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@Path("/api/numbers")
public class NumberResource {

	private static final Logger LOGGER = Logger.getLogger(NumberResource.class);
	
	@ConfigProperty(name = "number.separator", defaultValue = "false")
	boolean separator;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response generateBookNumbers() throws InterruptedException {
		LOGGER.info("Generating book numbers");
		Faker faker = new Faker();
		BookNumbers bookNumbers = new BookNumbers();
		bookNumbers.setIsbn10(faker.code().isbn10(separator));
		bookNumbers.setIsbn13(faker.code().isbn13(separator));
		bookNumbers.setAsin(faker.code().asin());
		bookNumbers.setEan8(faker.code().ean8());
		bookNumbers.setEan13(faker.code().ean13());
		bookNumbers.setGenerationDate(Instant.now());
		return Response.ok(bookNumbers).build();
	}
}