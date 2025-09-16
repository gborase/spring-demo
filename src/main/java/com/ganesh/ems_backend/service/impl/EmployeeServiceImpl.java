package com.ganesh.ems_backend.service.impl;

import com.ganesh.ems_backend.dto.EmployeeDTO;
import com.ganesh.ems_backend.entity.Employee;
import com.ganesh.ems_backend.exception.ResourceNotFoundException;
import com.ganesh.ems_backend.mapper.EmployeeMapper;
import com.ganesh.ems_backend.repository.EmployeeRepository;
import com.ganesh.ems_backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public EmployeeDTO getEmployeeByid(long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee is not exists with a given id: " + id));
        return EmployeeMapper.mapToEmployeeDTO(employee);
    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> all = employeeRepository.findAll();
        return all.stream().map(EmployeeMapper::mapToEmployeeDTO).toList();
    }

    @Override
    public String deleteEmployeeById(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with a given id: " + employeeId));
        employeeRepository.delete(employee);

        return "Deleted the Employee By Id: "+employeeId;
    }


    @Override
    public EmployeeDTO updateEmployee(long employeeId, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with a given id: " + employeeId));
employee.setId(employeeDTO.getId());
        employee.setLastName(employeeDTO.getLastName());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setEmail(employeeDTO.getEmail());
        Employee save = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDTO(employee);

    }



}
