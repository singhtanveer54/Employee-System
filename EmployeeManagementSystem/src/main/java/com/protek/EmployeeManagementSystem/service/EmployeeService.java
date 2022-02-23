package com.protek.EmployeeManagementSystem.service;

import com.protek.EmployeeManagementSystem.dao.EmployeeRepo;
import com.protek.EmployeeManagementSystem.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getAllEmployee(){

        List<Employee> listOfEmployees = employeeRepo.findAll();

        return listOfEmployees;
    }

    public Optional<Employee> getEmployeeById(int id){

        Optional<Employee> employeeById = employeeRepo.findById(id);

        return employeeById;
    }

    public void deleteEmployeeById(int id){

        employeeRepo.deleteById(id);
    }

    public Employee addEmployee(Employee addNewEmployee){

        Employee addedEmployee = new Employee(addNewEmployee.getId(),addNewEmployee.getFirstName(),
                addNewEmployee.getLastName(),addNewEmployee.getAge(),
                addNewEmployee.getEmail(),addNewEmployee.getSalary());

        return employeeRepo.saveAndFlush(addedEmployee);
    }
}
