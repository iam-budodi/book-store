package com.japhet.store.number;

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
			title = "Number API",
			description = "This API allows to generate all sorts of numbers",
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
		name = "numbers",
		description = "Anybody interested in standard book numbers"
			) 
		}
)
public class NumberApplication extends Application {

}
