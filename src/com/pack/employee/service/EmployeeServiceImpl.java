package com.pack.employee.service;

import com.pack.employee.entity.EmployeeEntity;
import com.pack.employee.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeEntity> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<EmployeeEntity> pagedResult = employeeRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public EmployeeEntity getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);

    }

    @Override
    public EmployeeEntity createOrUpdateEmployee(EmployeeEntity entity) {
        return employeeRepository.save(entity);

    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);

    }
}
