package com.ganesh.ems_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

        private long id;
        private String lastName;
        private String firstName;
        private String email;

}
