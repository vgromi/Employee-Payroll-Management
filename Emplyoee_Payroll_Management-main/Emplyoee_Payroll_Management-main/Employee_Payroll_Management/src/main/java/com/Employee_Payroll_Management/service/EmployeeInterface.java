package com.Employee_Payroll_Management.service;

import java.util.List;

import com.Employee_Payroll_Management.entities.Department;
import com.Employee_Payroll_Management.entities.Employee;

public interface EmployeeInterface {
    void insertEmployee(Employee employee);
    void deleteEmployeeById(Long empId);
    void updateEmployee(Employee employee);
    Employee viewEmployeeById(Long empId);
	List<Employee> getAllEmployees();
	List<Department> getDepartmentByEmployeeId(Long employeeId);
}