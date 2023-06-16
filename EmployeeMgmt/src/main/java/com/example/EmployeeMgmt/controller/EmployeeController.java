package com.example.EmployeeMgmt.controller;

import com.example.EmployeeMgmt.model.Employee;
import com.example.EmployeeMgmt.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // controller for getting all employees
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    // controller for getting a single employee using his/her id
    @GetMapping(path = "{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("employeeId") Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    // controller for adding new employee
    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    // controller for updating employee using his/her name
    @PutMapping(path = "{name}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("name") String name, @RequestBody Employee employee) {
        return employeeService.updateEmployee(name, employee);
    }

    // controller for deleteing employee by his/her id
    @DeleteMapping(path = "{employeeId}")
    public String deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}
