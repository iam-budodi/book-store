package com.japhet.store.number;

import static javax.ws.rs.core.Response.Status.OK;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.CoreMatchers.is;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.DisabledOnIntegrationTest;
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
	  void shouldSayPing() {
		  RestAssured.given()
	      .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN).
	    when()
	      .get("/api/numbers/ping").
	    then()
	      .statusCode(OK.getStatusCode())
	      .body(is("hello"));
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
	
	@DisabledOnIntegrationTest
	@Test
	void shouldPingSwaggerUI() {
		RestAssured
		.given()
		.when()
		.get("/q/swagger-ui")
		.then()
		.statusCode(OK.getStatusCode());
	}

	@Test
	void shouldPingLiveness() {
		RestAssured
		.given()
		.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
		.when()
		.get("/q/health/live")
		.then()
		.statusCode(OK.getStatusCode());
	}

	@Test
	void shouldPingReadiness() {
		RestAssured
		.given()
		.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
		.when()
		.get("/q/health/ready")
		.then()
		.statusCode(OK.getStatusCode());
	}

	@Test
	void shouldPingMetrics() {
		RestAssured
		.given()
		.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
		.when()
		.get("/q/metrics/application")
		.then()
		.statusCode(OK.getStatusCode());
	}

	@Test
	void shouldNotFindDummy() {
		RestAssured
		.given()
		.header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
		.when()
		.get("/api/numbers/dummy")
		.then()
		.statusCode(NOT_FOUND.getStatusCode());
	}

}
