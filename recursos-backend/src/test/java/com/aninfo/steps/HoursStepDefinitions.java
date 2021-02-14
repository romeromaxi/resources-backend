package com.aninfo.steps;

import com.aninfo.hours.HoursIntegrationServiceTest;
import com.aninfo.hours.model.Hours;
import com.aninfo.hours.exceptions.InvalidHoursException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class HoursStepDefinitions extends HoursIntegrationServiceTest {

    private Hours hours;
    private InvalidHoursException ihe;

    @Given("a resource id {int} who works {int} hours in the task {int}")
    public void a_resource_id_who_works_hours_in_the_task(Integer file, Integer quantHours, Integer idTask) {
        hours = createHours(file, quantHours, idTask, 20210214);
    }

    @When("save the hours")
    public void save_the_hours() {
        hours = saveHours(hours);
    }

    @Then("the resource id {int} has {int} hours assigned in the task {int}")
    public void the_resource_id_has_hours_assigned_in_the_task(Integer file, Integer quantHours, Integer idTask) {
        assertEquals(quantHours, hours.getQuantityHours());
    }

    @Given("loading {int} hours to the resource with id {int} in the task {int}")
    public void loading_hours_to_the_resource_with_id_in_the_task(Integer quantHours, Integer file, Integer idTask) {
        hours = createHours(file, quantHours, idTask, 20210214);
    }

    @When("trying to save the hours")
    public void trying_to_save_the_hours() {
        try {
            hours = saveHours(hours);
        } catch (InvalidHoursException ihe) {
            this.ihe = ihe;
        }
    }

    @Then("i get invalid number error")
    public void i_get_invalid_number_error() {
        assertNotNull(ihe);
    }




}