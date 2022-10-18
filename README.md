# Book Store

A simple app made up of two microservices and a user interface, all monitored by Prometheus.

## Overall Architecture

* BookStore UI: the Angular application allowing you to visually pick up a random book, create/read/delete a book and generate ISBN numbers.
* Number REST API: Simple HTTP microservice generating ISBN numbers.
* Book REST API: Allows CRUD operations on Books which are stored in a PostgreSQL database.

![architecture] (/architecture.png)

## Technologies used 

* Quarkus Runtime,
* Eclipse MicroProfile
* RESTEasy for REST APIs 
* JTA and Hibernate ORM with Panache to access relational database 
* Swagger and OpenAPI for documenting microservices REST endpoints
* JUnit 5, REST Assured, Hamcrest and TestContainers for testing 
* Prometheus
* Docker 
* Minikube, a lightweight kubernates distribution
* PostgreSQL
* Java 17
* Maven build tool
* GraalVM for building native executable
* NodeJS 

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/book-store-1.0.0-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Provided Code

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
