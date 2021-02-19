package com.aninfo.steps;

import com.aninfo.hours.HoursIntegrationServiceTest;
import com.aninfo.hours.model.Hours;
import com.aninfo.hours.exceptions.InvalidHoursException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.IntToLongFunction;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HoursStepDefinitions extends HoursIntegrationServiceTest {

    private Hours hours, hours1, hours2;
    private Collection<Hours> hoursList;
    private InvalidHoursException ihe;

    @Given("a resource id {int} who works {int} hours in the task {int}")
    public void a_resource_id_who_works_hours_in_the_task(Integer file, Integer quantHours, Integer idTask) {
        hours = createHours(file,quantHours, 15,idTask,20201005);
    }

    @When("save the hours")
    public void save_the_hours() {
        hours = saveHours(hours);
    }

    @Then("the resource id {int} has {int} hours assigned in the task {int}")
    public void the_resource_id_has_hours_assigned_in_the_task(Integer file, Integer quantHours, Integer idTask) {
        assertEquals(quantHours, hours.getQuantityHours());
    }

    @Given("a resource id {int} who works {int} hours and {int} minutes in the task {int}")
    public void a_resource_id_who_works_hours_and_minutes_in_the_task(Integer file, Integer quantHours, Integer minutes, Integer idTask) {
        hours = createHours(file,quantHours,minutes,idTask,20200215);
        hours = saveHours(hours);
    }


    @When("add {int} minutes")
    public void add_minutes(Integer minutesToChange) {
        hours = changeMinutes(hours.getId(), minutesToChange);
    }

    @Given("loading {int} hours to the resource with id {int} in the task {int}")
    public void loading_hours_to_the_resource_with_id_in_the_task(Integer quantHours, Integer file, Integer idTask) {
        hours = createHours(file, quantHours, 15, idTask, 20210214);
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


    @When("i modify the date to {int}")
    public void i_modify_the_date_to(Integer newDate) {
        hours.setDate(newDate);
    }

    @Then("the date of the {int} hours assigned to resource id {int} to task {int} is {int}")
    public void the_date_of_the_hours_assigned_to_resource_ir_to_task_is(Integer quantHours, Integer file, Integer idTask, Integer date) {
        assertEquals(date, hours.getDate());
    }


    @Given("a resource id {int} with {int} hours on {int} assigned to task {int}")
    public void a_resource_id_with_hours_on_assigned_to_task(Integer file, Integer quantHours, Integer date, Integer idTask) {
        hours = createHours(file, quantHours, 15, idTask, date);
    }

    @When("i modify the task to {int}")
    public void i_modify_the_task_to(Integer newIdTask) {
        hours.setTask(newIdTask);
    }

    @Then("the resource id {int} has {int} hours assigned to the new task {int}")
    public void the_resource_id_has_hours_assigned_to_the_new_task(Integer file, Integer quantHours, Integer idTask) {
        assertEquals(idTask, hours.getIdTask());
    }

    @Given("a resource id {int} with {int} hours loaded on {int} from a task {int}")
    public void a_resource_id_with_hours_loaded_from_a_task(Integer file, Integer quantHours, Integer date, Integer idTask) {
        hours = createHours(file, quantHours, 15, idTask, date);
        hours = saveHours(hours);
    }

    @When("i modify the quantity of worked hours to {int}")
    public void i_modify_the_quantity_of_worked_hours_to(Integer newQuantHours) {
        hours = changeHours(hours.getId(), newQuantHours);
    }

    @Then("the loading date is today")
    public void the_loading_date_is_today() {
        LocalDate today = LocalDate.now();
        int todayInt = today.getYear() * 10000 + today.getMonthValue() * 100 + today.getDayOfMonth();
        assertEquals(todayInt, hours.getLoadingDate());
    }

    @When("delete the hours")
    public void delete_the_hours() {
        deleteById(hours.getId());
    }

    @Then("hours have been deleted")
    public void hours_have_been_deleted() {
        Optional<Hours> oneHours = findById(hours.getId());
        assertEquals(oneHours.isPresent(), false);
    }

    @Given("a resource with id {int} with two hours loaded to different tasks and dates")
    public void a_resource_with_id_with_two_hours_loaded_to_different_tasks_and_dates(Integer file) {
        hours1 = createHours(file, 4, 15,10, 20210214);
        hours2 = createHours(file, 4, 15,20, 20210215);

        saveHours(hours1);
        saveHours(hours2);

        assertNotEquals(hours1.getDate(), hours2.getDate());
        assertNotEquals(hours1.getIdTask(), hours2.getIdTask());
    }

    @When("recovering the hours from the resource with id {int}")
    public void recovering_the_hours(Integer file) {
        hoursList = findByFile(file);
    }

    @Then("i get a list of {int} elements")
    public void i_get_a_list_of_elements(Integer loadedHours) {
        assertEquals(loadedHours, hoursList.size());
    }

    @Then("they are both associated to the resource with id {int}")
    public void they_are_both_associated_to_the_resource_with_id(Integer file) {
        Iterator<Hours> it = hoursList.iterator();
        assertEquals(it.next().getFile(), file);
        assertEquals(it.next().getFile(), file);
    }
}