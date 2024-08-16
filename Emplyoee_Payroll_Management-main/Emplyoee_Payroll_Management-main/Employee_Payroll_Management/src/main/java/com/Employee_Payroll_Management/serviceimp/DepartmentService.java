package com.Employee_Payroll_Management.serviceimp;

import com.Employee_Payroll_Management.entities.Department;
import com.Employee_Payroll_Management.service.DepartmentInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentService implements DepartmentInterface {
    private final SessionFactory factory;

    public DepartmentService(SessionFactory factory) {
        this.factory = factory;
    }
//insert method
    @Override
    public void insertDepartment(Department department) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
        }
    }
//delete method
    @Override
    public void deleteDepartmentById(Long departmentId) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Department department = session.get(Department.class, departmentId);
            if (department != null) {
                session.delete(department);
            }
            transaction.commit();
        }
    }
//update method
    @Override
    public void updateDepartment(Department department) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(department);
            transaction.commit();
        }
    }
//view method
    @Override
    public Department viewDepartmentById(Long departmentId) {
        try (Session session = factory.openSession()) {
            return session.get(Department.class, departmentId);
        }
    }

    @Override
    public List<Department> getAllDepartment() {
        try (Session session = factory.openSession()) {
            Query<Department> query = session.createQuery("FROM Department", Department.class);
            return query.list();
        }
    }

    @Override
    public List<Department> getDepartmentByEmployeeId(Long employeeId) {
        try (Session session = factory.openSession()) {
            Query<Department> query = session.createQuery("SELECT d FROM Department d JOIN d.employees e WHERE e.id = :empId", Department.class);
            query.setParameter("empId", employeeId);
            return query.list();
        }
    }
}
