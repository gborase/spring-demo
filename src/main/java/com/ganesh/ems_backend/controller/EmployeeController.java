package com.ganesh.ems_backend.controller;

import com.ganesh.ems_backend.dto.EmployeeDTO;
import com.ganesh.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

   private final EmployeeService employeeService;

   public EmployeeController(EmployeeService employeeService) {
      this.employeeService = employeeService;
   }

   @PostMapping("/create")
   public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO request ) {

      return new ResponseEntity<>(employeeService.createEmployee(request),HttpStatus.CREATED);

   }


}
