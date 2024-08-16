package com.Employee_Payroll_Management.serviceimp;

import com.Employee_Payroll_Management.entities.Company;
import com.Employee_Payroll_Management.service.CompanyInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CompanyService implements CompanyInterface {
    private final SessionFactory factory;

    public CompanyService(SessionFactory factory) {
        this.factory = factory;
    }
//insert method
    @Override
    public void insertCompany(Company company) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(company);
            transaction.commit();
        }
    }
//delete method
    @Override
    public void deleteCompanyById(long companyId) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Company company = session.get(Company.class, companyId);
            if (company != null) {
                session.delete(company);
            }
            transaction.commit();
        }
    }
//update method
    @Override
    public void updateCompany(Company company) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(company);
            transaction.commit();
        }
    }
//view method
    @Override
    public Company viewCompanyById(long companyId) {
        try (Session session = factory.openSession()) {
            return session.get(Company.class, companyId);
        }
    }

    @Override
    public List<Company> getAllCompany() {
        try (Session session = factory.openSession()) {
            Query<Company> query = session.createQuery("FROM Company", Company.class);
            return query.list();
        }
    }

    @Override
    public List<Company> getCompanyByEmployeeId(Long employeeId) {
        try (Session session = factory.openSession()) {
            Query<Company> query = session.createQuery("SELECT c FROM Company c JOIN c.departments d JOIN d.employees e WHERE e.id = :empId", Company.class);
            query.setParameter("empId", employeeId);
            return query.list();
        }
    }
}
