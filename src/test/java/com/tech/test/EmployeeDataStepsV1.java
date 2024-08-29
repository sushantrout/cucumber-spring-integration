package com.tech.test;

import com.tech.model.Employee;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeDataStepsV1 {

    private final Map<String, Employee> employeeData = new HashMap<>();

    @Given("the following employees are added to the map:")
    public void the_following_employees_are_added_to_the_map(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        for (List<String> row : rows.subList(1, rows.size())) { // Skipping header row
            String id = row.get(0);
            String name = row.get(1);
            String email = row.get(2);
            employeeData.put(id, new Employee(id, name, email));
        }
    }

    @Then("the map should contain {int} employees")
    public void the_map_should_contain_employees(int expectedCount) {
        Assertions.assertEquals(expectedCount, employeeData.size());
    }

    @Then("the employee with id {string} should have name {string} and email {string}")
    public void the_employee_with_id_should_have_name_and_email(String id, String expectedName, String expectedEmail) {
        Employee employee = employeeData.get(id);
        Assertions.assertNotNull(employee);
        Assertions.assertEquals(expectedName, employee.getName());
        Assertions.assertEquals(expectedEmail, employee.getEmail());
    }
}