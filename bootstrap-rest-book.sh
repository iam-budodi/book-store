#!/usr/bin/env bash
# tag::adocBootstrap[]
mvn -U io.quarkus:quarkus-maven-plugin:2.12.2.Final:create \
    -DplatformVersion=2.12.2.Final \
    -DprojectGroupId=com.japhet.store.quarkus-microservice \
    -DprojectArtifactId=rest-book \
    -DprojectVersion=1.0.0 \
    -DclassName="com.japhet.store.book.BookResource" \
    -Dpath="/api/books" \
    -Dextensions="resteasy, resteasy-jsonb, hibernate-orm-panache, jdbc-postgresql, hibernate-validator, smallrye-openapi"
# end::adocBootstrap[]

cd rest-book

# tag::adocDependencyFaultTolerance[]
./mvnw quarkus:add-extension -Dextensions="rest-client, smallrye-fault-tolerance"
# end::adocDependencyFaultTolerance[]

# tag::adocDependencyObservability[]
./mvnw quarkus:add-extension -Dextensions="smallrye-health, smallrye-metrics"
# end::adocDependencyObservability[]

# tag::adocDependencyDocker[]
./mvnw quarkus:add-extension -Dextensions="container-image-docker"
# end::adocDependencyDocker[]
