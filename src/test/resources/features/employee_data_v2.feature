Feature: Manage Employee Data

  Scenario Outline: Add employees to the employee data map and verify details
    Given the following employees are added to the map:
      | id    | name           | email                     |
      | 12345 | John Doe       | johndoe@example.com       |
      | 12346 | Jane Smith     | janesmith@example.com     |
      | 12347 | Bob Johnson    | bobjohnson@example.com    |
      | 12348 | Alice Williams | alicewilliams@example.com |
      | 12349 | Charlie Brown  | charliebrown@example.com  |
      | 12350 | David Wilson   | davidwilson@example.com   |
      | 12351 | Eve Davis      | evedavis@example.com      |
      | 12352 | Frank Miller   | frankmiller@example.com   |
      | 12353 | Grace Lee      | gracelee@example.com      |
      | 12354 | Henry Martin   | henrymartin@example.com   |
    Then the map should contain 10 employees
    And the employee with id "<id>" should have name "<name>" and email "<email>"

    Examples:
      | id    | name           | email                     |
      | 12345 | John Doe       | johndoe@example.com       |
      | 12346 | Jane Smith     | janesmith@example.com     |
      | 12347 | Bob Johnson    | bobjohnson@example.com    |
      | 12348 | Alice Williams | alicewilliams@example.com |
      | 12349 | Charlie Brown  | charliebrown@example.com  |
      | 12350 | David Wilson   | davidwilson@example.com   |
      | 12351 | Eve Davis      | evedavis@example.com      |
      | 12352 | Frank Miller   | frankmiller@example.com   |
      | 12353 | Grace Lee      | gracelee@example.com      |
      | 12354 | Henry Martin   | henrymartin@example.com   |
