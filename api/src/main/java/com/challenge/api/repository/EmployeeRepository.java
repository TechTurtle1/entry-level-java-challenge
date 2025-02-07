package com.challenge.api.repository;

import com.challenge.api.model.Employee;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for performing JPA operations on Employee entities
 *
 * This interface extends JpaRepository, which provides built-in methods
 * for interacting with the database, including methods for saving, deleting, and
 * finding Employee records by a unique UUID identifier
 */
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {}
