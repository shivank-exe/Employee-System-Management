package com.dracula.shivank.Employee.System.API.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class EmployeeModel {
    private Long employeeId;
    private  String firstName;
    private  String lastName;

    @Column(unique = true,nullable = false)
    private  String emailId;
}
