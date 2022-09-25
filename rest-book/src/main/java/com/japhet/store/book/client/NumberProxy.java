package com.japhet.store.book.client;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/api/numbers")
@Produces(MediaType.APPLICATION_JSON)
@RegisterRestClient
public interface NumberProxy {
	
	@GET
	IsbnNumbers generateNumbers();

}
