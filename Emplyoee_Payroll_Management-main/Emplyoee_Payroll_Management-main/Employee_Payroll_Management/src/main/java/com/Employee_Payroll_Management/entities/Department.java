package com.Employee_Payroll_Management.entities;
import javax.persistence.*;
@Entity
@Table(name = "Department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Dep_id")
    private Long dep_id;

    @Column(name = "Dep_name")
    private String dep_name;

    @ManyToOne
    @JoinColumn(name = "Company_id")
    private Company company;

    public Department() {
        // Default constructor
    }

    // Constructor
    public Department(String dep_name, Company company) {
        super();
        this.dep_name = dep_name;
        this.company = company;
    }

    // Getters and Setters
    public Long getDep_id() {
        return dep_id;
    }

    public void setDep_id(Long dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
