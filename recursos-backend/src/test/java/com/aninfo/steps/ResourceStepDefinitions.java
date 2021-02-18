package com.aninfo.steps;

import com.aninfo.recursos.ResourcesIntegrationServiceTest;
import com.aninfo.recursos.exceptions.ResourceNotFoundException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.aninfo.recursos.model.Resource;

public class ResourceStepDefinitions  extends ResourcesIntegrationServiceTest {

    Vector<Resource> resources = new Vector<>();
    Resource resource;
    private ResourceNotFoundException rnfe;

    @Given("there is an external system with three resources")
    public void there_is_an_external_system_with_three_resources() {
    }

    @When("reading the resources from the external system")
    public void reading_the_resources_from_the_external_system() {
        resources = readAllFromExternalSystem();
    }

    @Then("I get a list with {int} elements")
    public void i_get_a_list_with_elements(Integer numberOfResources) {
        assertEquals(numberOfResources, resources.size());
    }

    @Given("there is a resource in the external system with id {int}")
    public void there_is_a_resource_in_the_external_system_with_id(Integer int1) {
    }

    @When("recovering the resource with id {int} from the external system")
    public void recovering_the_resource_with_id_from_the_external_system(Integer file) {
        resource = readOneFromExternalSystem(file);
    }

    @Then("I get the resource with id {int}")
    public void i_get_the_resource_with_id(Integer file) {
        assertEquals(file, resource.getFile());
    }

    @Given("there is not a resource with id {int}")
    public void there_is_not_a_resource_with_id(Integer file) { }

    @When("trying to recover the resource with id {int}")
    public void trying_to_recover_the_resource_with_id(Integer file) {
        try {
            resource = readOneFromExternalSystem(file);
        } catch (ResourceNotFoundException rnfe) {
            this.rnfe = rnfe;
        }
    }

    @Then("I get resource not found error")
    public void i_get_resource_not_found_error() {
        assertNotNull(rnfe);
    }

}
