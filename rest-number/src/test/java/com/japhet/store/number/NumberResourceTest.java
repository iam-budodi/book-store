package com.japhet.store.number;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.Response.Status.OK;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;

@QuarkusTest
class NumberResourceTest {

	@Test
	void shouldGenerateBookNumbers() {
		RestAssured
		.given()
		.header(
				HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON
		)
		.when()
		.get("/api/numbers")
		.then()
		.statusCode(OK.getStatusCode())
				.body("$", hasKey("isbn_10"))
				.body("$", hasKey("isbn_13"))
				.body("$", hasKey("asin"))
				.body("$", hasKey("ean_8"))
				.body("$", hasKey("ean_13")
				).body("$", not(hasKey("generationDate")));
	}
	
	@Test
	void shouldPingOpenAPI() {
		RestAssured
		.given()
		.header(
				HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON
		)
		.when()
		.get("/q/openapi")
		.then()
		.statusCode(OK.getStatusCode());
	}
	
	@Test
	void shouldPingSwaggerUI() {
		RestAssured
		.given()
		.when()
		.get("/q/swagger-ui")
		.then()
		.statusCode(OK.getStatusCode());
	}

}
