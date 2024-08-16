package com.Employee_Payroll_Management.entities;

import javax.persistence.*;

@Entity
@Table(name = "payroll")
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    @Column(name = "emp_net_salary")
    private Double netSalary;

    @Column(name = "emp_salary_year")
    private String salaryYear;

    @Column(name = "emp_gross_salary")
    private Double grossSalary;
   
    public Payroll(){
    	//constructors
    }
 // Constructors
	public Payroll(Long id, Employee employee, Double netSalary, String salaryYear, Double grossSalary) {
		super();
		this.id = id;
		this.employee = employee;
		this.netSalary = netSalary;
		this.salaryYear = salaryYear;
		this.grossSalary = grossSalary;
	}
	//  Getters, and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(Double netSalary) {
		this.netSalary = netSalary;
	}

	public String getSalaryYear() {
		return salaryYear;
	}

	public void setSalaryYear(String salaryYear) {
		this.salaryYear = salaryYear;
	}

	public Double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(Double grossSalary) {
		this.grossSalary = grossSalary;
	}

    
}
