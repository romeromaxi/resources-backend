package com.aninfo.recursos;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.aninfo.recursos.model.Resource;

public class StepDefinitions extends ResourcesIntegrationServiceTest {

    Vector<Resource> resources = new Vector<>();

    @Given("there is an external system with three resources")
    public void there_is_an_external_system_with_three_resources() {}

    @When("reading the resources from the external system")
    public void reading_the_resources_from_the_external_system() {
        resources = readFromExternalSystem();
    }

    @Then("I get a list with {int} elements")
    public void i_get_a_list_with_elements(Integer numberOfResources) {
        assertEquals(numberOfResources, resources.size());
    }



}
