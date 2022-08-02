package com.dracula.shivank.Employee.System.API.Controller;

import com.dracula.shivank.Employee.System.API.Entity.EmployeeEntity;
import com.dracula.shivank.Employee.System.API.Model.EmployeeModel;
import com.dracula.shivank.Employee.System.API.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public EmployeeEntity saveEmployee(@RequestBody EmployeeModel employeeModel){
        return  employeeService.saveEmployee(employeeModel);
    }

    @GetMapping
    public List<EmployeeModel> fetchAllEmployees(){
        return  employeeService.fetchAllEmployees();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){

    boolean  deleted = employeeService.deleteEmployee(employeeId)==true ? true:false;
      return  ResponseEntity.ok("deleted"+"     "+deleted);

    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> fetchEmployeeById(@PathVariable("id") Long employeeId){
       return  ResponseEntity.ok(employeeService.fetchEmployeeById(employeeId));
    }
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable("id") Long employeeId,
                                                        @RequestBody EmployeeModel employeeModel){
        return ResponseEntity.ok(employeeService.updateEmployee(employeeId,employeeModel));
    }
}
