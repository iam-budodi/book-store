package com.japhet.store.book.client;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.test.Mock;

@Mock
@ApplicationScoped
@RestClient
public class MockNumberProxy implements NumberProxy {

	@Override
	public IsbnNumbers generateNumbers() {
		IsbnNumbers isbnNumbers = new IsbnNumbers();
	    isbnNumbers.isbn13 = "Dummy Isbn 13";
	    isbnNumbers.isbn10 = "Dummy Isbn 10";
	    return isbnNumbers;
	}

}
