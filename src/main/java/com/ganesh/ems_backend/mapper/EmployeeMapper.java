package com.ganesh.ems_backend.mapper;

import com.ganesh.ems_backend.dto.EmployeeDTO;
import com.ganesh.ems_backend.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDTO(Employee employee){

        return new EmployeeDTO(
                employee.getId(),
                employee.getLastName(),
                employee.getFirstName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDTO employeeDTO){
        return new Employee(
                employeeDTO.getId(),
                employeeDTO.getLastName(),
                employeeDTO.getFirstName(),
                employeeDTO.getEmail()
        );
    }

}
