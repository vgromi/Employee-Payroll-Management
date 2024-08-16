package com.Employee_Payroll_Management.service;

import com.Employee_Payroll_Management.entities.Payroll;

import java.util.List;

public interface PayrollInterface {
    void insertPayroll(Payroll payroll);
    void deletePayrollById(int payrollId);
    void updatePayroll(Payroll payroll);
    Payroll viewPayrollById(int payrollId);
    List<Payroll> getAllPayrolls();
    List<Payroll> getPayrollsByEmployeeId(Long employeeId);
}