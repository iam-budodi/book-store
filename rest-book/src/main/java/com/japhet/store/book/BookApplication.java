package com.japhet.store.book;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationPath("/")
@OpenAPIDefinition(
	info = @Info(
			title = "Book API",
			description = "This API allows CRUD operations on books",
			version = "1.0", 
			contact = @Contact(
					name = "@iamBudodi",
					url = "https://twitter.com/iamBudodi"
			)
	), 
	externalDocs = @ExternalDocumentation(
			url = "https://github.com/iam-budodi/book-store",
			description = "All the Book Store code"
	), 
	tags = { 
		@Tag(
			name = "api",
			description = "Public API that can be used by anybody"
			), 
		@Tag(
		name = "books",
		description = "Anybody interested in books"
			) 
		}
)
public class BookApplication extends Application {

}
