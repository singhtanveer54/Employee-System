package com.protek.EmployeeManagementSystem.controller;

import com.protek.EmployeeManagementSystem.model.Employee;
import com.protek.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping(path = "/employees")
    public ResponseEntity<Object> getAllEmployee(){

        List<Employee> listOfEmployees = employeeService.getAllEmployee();

        return ResponseEntity.status(200).body(listOfEmployees);
    }

    @GetMapping(path = "/employees/{id}")
    public ResponseEntity<Object> getEmployeeById(@PathVariable("id") int id){
        Optional<Employee> employeeById = employeeService.getEmployeeById(id);

        return ResponseEntity.status(200).body(employeeById);
    }

    @DeleteMapping(value = "/employee/{employee_id}")
    public ResponseEntity<Object> deleteEmployeeById(@PathVariable("employee_id") int id){

        employeeService.deleteEmployeeById(id);
        return ResponseEntity.status(400).body("Successfully deleted");
    }
}
