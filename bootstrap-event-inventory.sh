#!/usr/bin/env bash
# tag::adocBootstrap[]
mvn io.quarkus:quarkus-maven-plugin:2.12.2.Final:create \
    -DplatformVersion=2.12.2.Final \
    -DprojectGroupId=com.japhet.store.quarkus-microservice \
    -DprojectArtifactId=event-inventory \
    -DprojectVersion=1.0.0 \
    -DclassName="com.japhet.store.inventory.InventoryResource" \
    -Dpath="/api/inventory" \
    -Dextensions="resteasy, resteasy-jsonb, mongodb-panache, smallrye-openapi, kafka"
# end::adocBootstrap[]

cd event-inventory

# tag::adocDependencyFaultTolerance[]
./mvnw quarkus:add-extension -Dextensions="rest-client, smallrye-fault-tolerance"
# end::adocDependencyFaultTolerance[]
