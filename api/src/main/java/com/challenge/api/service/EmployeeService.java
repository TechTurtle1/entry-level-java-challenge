package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.repository.EmployeeRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The Service layer of the REST API
 *
 * This service layer handles the business logic related to Employees. Some operations include
 * retrieving all employees, retrieving an employee with a specified ID, or creating a new employee.
 * It also provides an EmployeeRepository object that handles data persistence.
 */
@Service
public class EmployeeService {

    /**
     * This is the Repository layer that the Service layer uses for data persistence.
     */
    private final EmployeeRepository employeeRepository;

    /**
     * Constructs a new instance of the EmployeeRepository object.
     * @param employeeRepository The EmployeeRepository object the Service layer uses to access the Repository layer.
     */
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Retrieves all employees in the database.
     * @return A list of all the employees currently in the database.
     */
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    /**
     * Retrieves the employee in the database with the specified ID, represented by a UUID.
     * @param uuid The ID of the employee to be retrieved.
     * @return The employee with the specified ID if the employee exists.
     * @throws RuntimeException if an employee with the specified ID does not exist.
     */
    public Employee getEmployeeByUUID(UUID uuid) {
        return this.employeeRepository
                .findById(uuid)
                .orElseThrow(() -> new RuntimeException("Unable to find an employee with UUID " + uuid + "."));
    }

    /**
     * Attempts to create, insert into the repository, and return a new Employee object.
     * @param requestBody A serialized object that may contain information to create a new Employee object.
     * @return Newly created Employee.
     * @throws IllegalArgumentException if the method fails to create a new Employee object.
     */
    public Employee createNewEmployee(Object requestBody) {
        // Create a new ObjectMapper that will attempt to convert the Object into an Employee.
        ObjectMapper objectMapper = new ObjectMapper();
        // Create a new JavaTimeModule that will assist with the deserialization and serialization of Instant objects
        JavaTimeModule timeModule = new JavaTimeModule();
        objectMapper.registerModule(timeModule);
        try {
            Employee employee = objectMapper.convertValue(requestBody, Employee.class);
            // The employee's UUID cannot be null when in the repository. Generate a new UUID before insertion.
            if (employee.getUuid() == null) {
                employee.setUuid(UUID.randomUUID());
            }
            // Save and return the new Employee object.
            return this.employeeRepository.save(employee);
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to deserialize the data to an object of type 'Employee'.");
        }
    }
}
