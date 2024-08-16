package com.Employee_Payroll_Management.service;

import java.util.List;
import com.Employee_Payroll_Management.entities.*;
public interface CompanyInterface {
	 void insertCompany(Company company);
	    void deleteCompanyById(long companyId);
	    void updateCompany(Company company);
	    Company viewCompanyById(long companyId);
	    List<Company> getAllCompany();
	    List<Company> getCompanyByEmployeeId(Long employeeId);
}
