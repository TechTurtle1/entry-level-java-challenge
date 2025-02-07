package com.challenge.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.time.Instant;
import java.util.UUID;

/**
 * Represents an employee with an id, first name, last name, full name, salary, age, job title, email, and
 * contract hire/termination dates.
 *
 * This class provides the above properties of an Employee, including getter/setter methods. This class also implements
 * the EmployeeInterface interface.
 */
@Entity
public class Employee implements EmployeeInterface {

    @Id
    private UUID uuid;

    private String firstName;
    private String lastName;
    private String fullName;
    private Integer salary;
    private Integer age;
    private String jobTitle;
    private String email;
    private Instant contractHireDate;
    private Instant contractTerminationDate;

    /**
     * Default constructor for an Employee with no values set
     */
    public Employee() {}

    /**
     *
     * @param uuid The ID of the employee.
     * @param firstName The employee's first name.
     * @param lastName The employee's last name.
     * @param fullName The employee's full name. Does not necessarily have to be just the first and last name,
     *                 as it can also include a title (e.g. Jr.) or a middle name
     * @param salary The employee's yearly salary.
     * @param age The age of the employee.
     * @param jobTitle The job title of the employee.
     * @param email The employee's work email.
     * @param contractHireDate The date in which the employee starts employment at the company.
     * @param contractTerminationDate The date in which the employee leaves the company. 'null' if the employee
     *                                still works at the company.
     */
    public Employee(
            UUID uuid,
            String firstName,
            String lastName,
            String fullName,
            Integer salary,
            Integer age,
            String jobTitle,
            String email,
            Instant contractHireDate,
            Instant contractTerminationDate) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = fullName;
        this.salary = salary;
        this.jobTitle = jobTitle;
        this.age = age;
        this.email = email;
        this.contractHireDate = contractHireDate;
        this.contractTerminationDate = contractTerminationDate;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String name) {
        this.fullName = name;
    }

    public Integer getSalary() {
        return this.salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Instant getContractHireDate() {
        return this.contractHireDate;
    }

    public void setContractHireDate(Instant date) {
        this.contractHireDate = date;
    }

    public Instant getContractTerminationDate() {
        return this.contractTerminationDate;
    }

    public void setContractTerminationDate(Instant date) {
        this.contractTerminationDate = date;
    }
}
