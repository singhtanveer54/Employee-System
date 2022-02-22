package com.protek.EmployeeManagementSystem.dao;

import com.protek.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
