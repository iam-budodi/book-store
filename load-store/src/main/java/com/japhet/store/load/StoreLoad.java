package com.japhet.store.load;

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