package com.aninfo.steps;

import com.aninfo.hours.HoursIntegrationServiceTest;
import com.aninfo.hours.model.Hours;
import com.aninfo.recursos.ResourcesIntegrationServiceTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HoursStepDefinitions extends HoursIntegrationServiceTest {

    private Hours hours;

    @Given("a resource id {int} who works {int} hours in the task {int}")
    public void a_resource_id_who_works_hours_in_the_task(Integer file, Integer quantHours, Integer idTask, Integer date) {
        hours = createHours(file, quantHours, idTask, date);
    }

    @When("save the hours")
    public void save_the_hours() {
        hours = saveHours(hours);
    }

    @Then("the resource id {int} has {int} hours assigned in the task {int}")
    public void the_resource_id_has_hours_assigned_in_the_task(Integer file, Integer quantHours, Integer idTask) {
        assertEquals(quantHours, hours.getQuantityHours());
    }


}