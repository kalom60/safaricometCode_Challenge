package com.example.EmployeeMgmt.service;

import com.example.EmployeeMgmt.model.Employee;
import com.example.EmployeeMgmt.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // service for fetching all employees
    public ResponseEntity<List<Employee>> getAllEmployee() {
        try {
            List<Employee> employees = employeeRepository.findAll();
            return ResponseEntity.ok(employees);
        } catch (IllegalStateException ex) {
            throw new IllegalStateException("Something Wrong");
        }
    }

    // service for fetching single employee by the provided id
    public ResponseEntity<Employee> getEmployeeById(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            throw new IllegalStateException("employee with id " + employeeId + " is not fouund");
        }
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(null);
        return ResponseEntity.ok(employee);
    }

    // service that add new employee
    public ResponseEntity<Employee> addEmployee(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
    }

    // service for update employee by the provided name
    @Transactional
    public ResponseEntity<Employee> updateEmployee(String name, Employee employee) {
        Optional<Employee> optionalEmployee = employeeRepository.findUserByName(name);
        if (!optionalEmployee.isPresent()) {
            throw new IllegalStateException("\"Employee with name \" + name + \" is not found\"");
        }

        Employee existingEmployee = employeeRepository.findUserByName(name).orElseThrow(null);

        if (employee.getName() != null) {
            existingEmployee.setName(employee.getName());
        }

        if (employee.getTitle() != null) {
            existingEmployee.setTitle(employee.getTitle());
        }

        if (employee.getDepartment() != null) {
            existingEmployee.setDepartment(employee.getDepartment());
        }


        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return ResponseEntity.ok(updatedEmployee);
    }

    // service for deleteing employee by his/her id
    public String deleteEmployee(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if (!exists) {
            throw new IllegalStateException("employee with id " + employeeId + " is not found");
        }

        employeeRepository.deleteById(employeeId);
        return "Successfully Deleted";
    }
}
