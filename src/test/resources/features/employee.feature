Feature: Employee Management API

  Scenario: Retrieve employee details by ID
    Given an employee exists with ID "12345"
    When I retrieve the employee details for ID "12345"
    Then the employee name should be "John Doe"
    And the employee email should be "johndoe@example.com"
