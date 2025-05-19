package com.pack.employee.controller;

import com.pack.employee.entity.EmployeeEntity;
import com.pack.employee.exception.ResourceNotFoundException;
import com.pack.employee.service.EmployeeService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1")
public class EmployeeController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeEntity>> getAllEmployees(@RequestParam(defaultValue = "0") Integer pageNo,
                                                          @RequestParam(defaultValue = "10") Integer pageSize,
                                                          @RequestParam(defaultValue = "id") String sortBy) {
        List<EmployeeEntity> entity = employeeService.getAllEmployees(pageNo, pageSize, sortBy);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeEntity> getEmployeeById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        EmployeeEntity entity = Optional.of(employeeService.getEmployeeById(id)).orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/employee")
    public ResponseEntity<EmployeeEntity> createOrUpdateEmployee(@Validated @RequestBody EmployeeEntity employee) throws ResourceNotFoundException {
        EmployeeEntity entity = employeeService.createOrUpdateEmployee(employee);
        return new ResponseEntity<>(entity, new HttpHeaders(), HttpStatus.CREATED);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable("id") Long id) throws ResourceNotFoundException {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }
}