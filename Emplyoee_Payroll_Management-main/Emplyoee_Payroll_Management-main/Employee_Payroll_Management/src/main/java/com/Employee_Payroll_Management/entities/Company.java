package com.Employee_Payroll_Management.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Company")
public class Company {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Company_id") 
	private Long com_id;
    @Column(name = "Company_Name")
    private String com_name;

    @Column(name = "Company_Mobile")
    private String com_mob;
    
    @Column(name = "Company_Address")
    private String com_address;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Department> departments;

    public Company() {
        // Default constructor
    }

    // Constructor
    public Company(String com_name, String com_mob, String com_address) {
        super();
        this.com_name = com_name;
        this.com_mob = com_mob;
        this.com_address = com_address;
    }

    public Company(Long com_id) {
        super();
        this.com_id = com_id;
    }

    // Getters and Setters
    public Long getCom_id() {
        return com_id;
    }

    public void setCom_id(Long com_id) {
        this.com_id = com_id;
    }

    public String getCom_name() {
        return com_name;
    }

    public void setCom_name(String com_name) {
        this.com_name = com_name;
    }

    public String getCom_mob() {
        return com_mob;
    }

    public void setCom_mob(String com_mob) {
        this.com_mob = com_mob;
    }

    public String getCom_address() {
        return com_address;
    }

    public void setCom_address(String com_address) {
        this.com_address = com_address;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }
}
