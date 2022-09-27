package com.japhet.store.number;

import io.quarkus.runtime.annotations.RegisterForReflection;
import net.datafaker.Code;
import net.datafaker.Faker;
import net.datafaker.service.FakeValuesService;

@RegisterForReflection(
		targets = { FakeValuesService.class, Faker.class, Code.class }
)
public class ReflectionConfig {

}
