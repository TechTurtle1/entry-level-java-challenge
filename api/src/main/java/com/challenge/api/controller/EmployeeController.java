package com.challenge.api.controller;

import com.challenge.api.model.Employee;
import com.challenge.api.service.EmployeeService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The Controller layer of the REST API
 *
 * This controller handles HTTP requests related to Employee entities. Some operations include
 * retrieving all employees, retrieving an employee with a specified ID, or creating a new employee.
 * It also provides an EmployeeService object that handles the business logic in the Service layer.
 */
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    /**
     * This is the Service layer that the EmployeeController uses to handle the business logic.
     */
    private EmployeeService employeeService;

    /**
     * Constructs a new instance of the EmployeeController class.
     * @param employeeService The EmployeeService object the controller uses to access the Service layer.
     */
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Retrieves all employees currently in the repository.
     * @return One or more Employees.
     */
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    /**
     * Attempts to retrieve the employee with the specified UUID.
     * @param uuid Employee UUID.
     * @return Requested Employee if exists.
     */
    @GetMapping("/employees/{uuid}")
    public Employee getEmployeeByUuid(@PathVariable UUID uuid) {
        return employeeService.getEmployeeByUUID(uuid);
    }

    /**
     * Attempts to create, insert into the repository, and return a new Employee object.
     * @param requestBody A serialized object that may contain information to create a new Employee object.
     * @return Newly created Employee.
     */
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Object requestBody) {
        return employeeService.createNewEmployee(requestBody);
    }
}
