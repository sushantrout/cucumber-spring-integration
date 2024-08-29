package com.tech.service;

import com.tech.model.Employee;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    private final Map<String, Employee> employeeData = new HashMap<>();

    public EmployeeService() {
        employeeData.put("12345", new Employee("12345", "John Doe", "johndoe@example.com"));
        employeeData.put("12346", new Employee("12346", "Jane Smith", "janesmith@example.com"));
        employeeData.put("12347", new Employee("12347", "Bob Johnson", "bobjohnson@example.com"));
        employeeData.put("12348", new Employee("12348", "Alice Williams", "alicewilliams@example.com"));
        employeeData.put("12349", new Employee("12349", "Charlie Brown", "charliebrown@example.com"));
        employeeData.put("12350", new Employee("12350", "David Wilson", "davidwilson@example.com"));
        employeeData.put("12351", new Employee("12351", "Eve Davis", "evedavis@example.com"));
        employeeData.put("12352", new Employee("12352", "Frank Miller", "frankmiller@example.com"));
        employeeData.put("12353", new Employee("12353", "Grace Lee", "gracelee@example.com"));
        employeeData.put("12354", new Employee("12354", "Henry Martin", "henrymartin@example.com"));
    }

    public Employee getEmployeeById(String id) {
        return employeeData.get(id);
    }
}
