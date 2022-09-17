package com.japhet.store.load;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


//tag::adocSnippet[]
public class StoreLoad {

public static void main(String[] args) {
 Thread bookScenario = new Thread(new ScenarioBook());
 bookScenario.start();
 Thread numberScenario = new Thread(new ScenarioNumber());
 numberScenario.start();
}
}
//end::adocSnippet[]