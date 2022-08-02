package com.dracula.shivank.Employee.System.API.Repository;

import com.dracula.shivank.Employee.System.API.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {

}
