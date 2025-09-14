package com.ganesh.ems_backend.service;

import com.ganesh.ems_backend.dto.EmployeeDTO;
import org.springframework.stereotype.Service;


public interface EmployeeService {

    EmployeeDTO createEmployee(EmployeeDTO employ);


}
