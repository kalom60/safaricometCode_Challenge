package com.example.EmployeeMgmt.repository;

import com.example.EmployeeMgmt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT s FROM Employee s WHERE s.name = ?1")
    Optional<Employee> findUserByName(String name);
}
