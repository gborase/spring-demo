package com.ganesh.ems_backend.controller;

import com.ganesh.ems_backend.dto.EmployeeDTO;
import com.ganesh.ems_backend.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

   @GetMapping("/get/{id}")
   public ResponseEntity<EmployeeDTO> createEmployee(@PathVariable(name ="id") long  employeeId) {
      return new ResponseEntity<>(employeeService.getEmployeeByid(employeeId),HttpStatus.OK);
   }

   @GetMapping("/get/employees")
   public ResponseEntity<List<EmployeeDTO>> getEmployeesList() {
      return new ResponseEntity<>(employeeService.getAllEmployee(),HttpStatus.OK);
   }

   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> deleteEmployeeById(@PathVariable(name ="id") long  employeeId) {
      return new ResponseEntity<>(employeeService.deleteEmployeeById(employeeId),HttpStatus.OK);
   }
   @PutMapping("/update/{id}")
   public ResponseEntity<EmployeeDTO> updateEmployeeById(@PathVariable(name="id") long employeeId,@RequestBody EmployeeDTO employeeDTO) {
      return new ResponseEntity<>(employeeService.updateEmployee(employeeId,employeeDTO),HttpStatus.OK);
   }

}
