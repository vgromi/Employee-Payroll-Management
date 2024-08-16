package com.Employee_Payroll_Management.entities;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id")
    private Long id;

    @Column(name = "emp_name")
    private String name;

    @Column(name = "emp_mobile_no")
    private String mobileNo;

    @Column(name = "emp_dob")
    private Date dob;

    @Column(name = "emp_state")
    private String state;

    @Column(name = "emp_city")
    private String city;

    @Column(name = "emp_doj")
    private Date doj;

    public Employee() {
        // Default constructor
    }

    // Constructor with java.sql.Date for date fields
    public Employee(String name, String mobileNo, Date dob, String state, String city, Date doj) {
        this.name = name;
        this.mobileNo = mobileNo;
        this.dob = dob;
        this.state = state;
        this.city = city;
        this.doj = doj;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }
}
