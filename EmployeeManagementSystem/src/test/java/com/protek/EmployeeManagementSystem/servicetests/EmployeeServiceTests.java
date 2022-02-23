package com.protek.EmployeeManagementSystem.servicetests;

import com.protek.EmployeeManagementSystem.dao.EmployeeRepo;
import com.protek.EmployeeManagementSystem.model.Employee;
import com.protek.EmployeeManagementSystem.service.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EmployeeServiceTests {

    private EmployeeService employeeService;

    private EmployeeRepo employeeRepo;

    @BeforeEach
    public void setUp(){
        this.employeeService = mock(EmployeeService.class);
        this.employeeRepo = mock(EmployeeRepo.class);
    }

    @Test
    public void getAllEmployeePositive(){

        Employee employee1 = new Employee(1,"Tanveer","Singh",29,
                "singhtanveer54@list.com",34567.98);
        Employee employee2 = new Employee(1,"Yudhveer","Rana",32,
                "singhyudhveer@list.com",27434.98);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);

        when(employeeRepo.findAll()).thenReturn(employees);

        employeeService = new EmployeeService(employeeRepo);

        Employee expected1 = new Employee(1,"Tanveer","Singh",29,
                "singhtanveer54@list.com",34567.98);

        Employee expected2 = new Employee(1,"Yudhveer","Rana",32,
                "singhyudhveer@list.com",27434.98);

        List<Employee> expectedEmployees = new ArrayList<>();
        expectedEmployees.add(expected1);
        expectedEmployees.add(expected2);

        List<Employee> actual = employeeService.getAllEmployee();

        Assertions.assertEquals(expectedEmployees,actual);
    }
}
