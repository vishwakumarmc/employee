package com.pack.employee.service;

import com.pack.employee.entity.EmployeeEntity;
import com.pack.employee.exception.ResourceNotFoundException;

import java.util.List;

public interface EmployeeService {
        public List<EmployeeEntity> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy);
        public EmployeeEntity getEmployeeById(Long id);
        public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) throws ResourceNotFoundException;
        public void deleteEmployeeById(Long id) throws ResourceNotFoundException;
}
