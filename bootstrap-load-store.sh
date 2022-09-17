#!/usr/bin/env bash
# tag::adocBootstrap[]
mvn -U io.quarkus:quarkus-maven-plugin:2.12.2.Final:create \
    -DplatformVersion=2.12.2.Final \
    -DprojectGroupId=com.japhet.store.quarkus-microservice \
    -DprojectArtifactId=load-store \
    -DprojectVersion=1.0.0 \
    -DclassName="com.japhet.store.load.StoreLoad" \
    -Dpath="/api/numbers" \
    -Dextensions="resteasy"
# end::adocBootstrap[]