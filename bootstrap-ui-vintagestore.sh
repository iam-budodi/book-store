#!/usr/bin/env bash
mvn io.quarkus:quarkus-maven-plugin:2.12.2.Final:create \
    -DplatformVersion=2.12.2.Final \
    -DprojectGroupId=com.japhet.store.quarkus-microservice \
    -DprojectArtifactId=ui-vintagestore \
    -DprojectVersion=1.0.0 \
    -Dextensions="undertow"
