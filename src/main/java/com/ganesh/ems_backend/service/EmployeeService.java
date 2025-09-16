package com.ganesh.ems_backend.service;

import com.ganesh.ems_backend.dto.EmployeeDTO;

import java.util.List;


public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employ);
    EmployeeDTO getEmployeeByid(long id);
   List<EmployeeDTO> getAllEmployee();
   String deleteEmployeeById(long employeeId);
   EmployeeDTO updateEmployee(long employeeId,EmployeeDTO employeeDTO);

}
