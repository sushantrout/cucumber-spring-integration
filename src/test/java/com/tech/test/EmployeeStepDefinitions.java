package com.tech.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.model.Employee;
import com.tech.service.EmployeeService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeStepDefinitions {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private EmployeeService employeeService;

    private MockMvc mockMvc;
    private MvcResult mvcResult;
    private String employeeId;

    @Given("an employee exists with ID {string}")
    public void anEmployeeExistsWithID(String id) {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        employeeId = id;
    }

    @When("I retrieve the employee details for ID {string}")
    public void iRetrieveTheEmployeeDetailsForID(String id) throws Exception {
        mvcResult = mockMvc.perform(get("/employees/" + id))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Then("the employee name should be {string}")
    public void theEmployeeNameShouldBe(String expectedName) throws Exception {
        String jsonResponse = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(jsonResponse, Employee.class);
        assertEquals(expectedName, employee.getName(), "Employee name should match");
    }

    @Then("the employee email should be {string}")
    public void theEmployeeEmailShouldBe(String expectedEmail) throws Exception {
        String jsonResponse = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        Employee employee = objectMapper.readValue(jsonResponse, Employee.class);
        assertEquals(expectedEmail, employee.getEmail(), "Employee email should match");
    }
}
