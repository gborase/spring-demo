package com.ganesh.ems_backend.service.impl;

import com.ganesh.ems_backend.dto.EmployeeDTO;
import com.ganesh.ems_backend.entity.Employee;
import com.ganesh.ems_backend.mapper.EmployeeMapper;
import com.ganesh.ems_backend.repository.EmployeeRepository;
import com.ganesh.ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

// Tell the spring boot to create the bean for the class
@Service
public class EmployeeServiceImpl implements EmployeeService {

// We added the dependency of employeeRepository through constructor dependency injection
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employDTO) {
        Employee employee = EmployeeMapper.mapToEmployee(employDTO);
        Employee save = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(save);


    }




}
