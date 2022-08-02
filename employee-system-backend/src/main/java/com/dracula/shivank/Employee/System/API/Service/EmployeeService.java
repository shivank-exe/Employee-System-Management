package com.dracula.shivank.Employee.System.API.Service;

import com.dracula.shivank.Employee.System.API.Entity.EmployeeEntity;
import com.dracula.shivank.Employee.System.API.Model.EmployeeModel;
import com.dracula.shivank.Employee.System.API.Repository.EmployeeRepository;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public EmployeeEntity saveEmployee(EmployeeModel employeeModel) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeModel,employeeEntity);
        employeeRepository.save(employeeEntity);
        return employeeEntity;
    }

    public List<EmployeeModel> fetchAllEmployees() {
       List<EmployeeEntity> employeeEntities= employeeRepository.findAll();
       List<EmployeeModel> employeeModels=
               employeeEntities
               .stream()
               .map(emp-> new EmployeeModel(
                       emp.getEmployeeId(),
                       emp.getFirstName(),
                       emp.getLastName(),
                       emp.getEmailId()))
                       .collect(Collectors.toList());
//       for(int i=0;i<employeeEntities.size()-1;i++) {
//           EmployeeEntity employee = employeeEntities.get(i);
//
//           // System.out.println("employee = " + employee);
//
//           employeeModel.setEmployeeId(employee.getEmployeeId());
//           employeeModel.setEmailId(employee.getEmailId());
//           employeeModel.setFirstName(employee.getFirstName());
//           employeeModel.setLastName(employee.getLastName());
//
//           //  System.out.println("employeeModel = " + employeeModel);
//
//           employeeModels.add(employeeModel);
//       }
//        System.out.println("employeeModels = " + employeeModels);
       return  employeeModels;
    }

    public Boolean deleteEmployee(Long employeeId) {

        employeeRepository.deleteById(employeeId);
        return true;
    }

    public EmployeeModel fetchEmployeeById(Long employeeId) {
        EmployeeEntity employee= employeeRepository.findById(employeeId).get();

         EmployeeModel employeeModel = new EmployeeModel();

         BeanUtils.copyProperties(employee,employeeModel);

       return employeeModel;
    }

    public EmployeeModel updateEmployee(Long employeeId, EmployeeModel employeeModel) {
        EmployeeEntity employeeEntity= employeeRepository.findById(employeeId).get();
        BeanUtils.copyProperties(employeeModel,employeeEntity);

        System.out.println("employeeEntity = " + employeeEntity);

        employeeRepository.save(employeeEntity);

        return employeeModel;
    }
}
