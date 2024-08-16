package com.Employee_Payroll_Management.service;

import java.util.List;

import com.Employee_Payroll_Management.entities.*;

public interface DepartmentInterface {
	 void insertDepartment(Department department);
	    void deleteDepartmentById(Long empId);
	    void updateDepartment(Department department);
	    Department viewDepartmentById(Long empId);
	    List<Department> getAllDepartment();
	    List<Department> getDepartmentByEmployeeId(Long employeeId);
}
