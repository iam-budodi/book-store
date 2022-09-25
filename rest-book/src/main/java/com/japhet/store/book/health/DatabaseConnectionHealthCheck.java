package com.japhet.store.book.health;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.japhet.store.book.Book;
import com.japhet.store.book.BookService;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

@Readiness
@ApplicationScoped
public class DatabaseConnectionHealthCheck implements HealthCheck {

	@Inject
	BookService bookService;

	@Override
	public HealthCheckResponse call() {
		HealthCheckResponseBuilder responseBuilder = 
				HealthCheckResponse.named("Book Datasource connection health check");
		
		try {
			List<Book> books = bookService.findAllBooks();
			responseBuilder.withData(
					"Number of Books in the database", 
					books.size()
			).up();
		} catch (IllegalStateException iex) {
			responseBuilder.down();
		}

		return responseBuilder.build();
	}

}
