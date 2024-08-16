package com.Employee_Payroll_Management.serviceimp;

import com.Employee_Payroll_Management.entities.Department;
import com.Employee_Payroll_Management.entities.Employee;
import com.Employee_Payroll_Management.service.EmployeeInterface;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;



public class EmployeeService implements EmployeeInterface {

    private final SessionFactory factory;

    public EmployeeService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void insertEmployee(Employee employee) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployeeById(Long empId) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, empId);
            if (employee != null) {
                session.delete(employee);
            }
            transaction.commit();
        }
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee viewEmployeeById(Long empId) {
        try (Session session = factory.openSession()) {
            return session.get(Employee.class, empId);
        }
    }

    @Override
    public List<Employee> getAllEmployees() {
        try (Session session = factory.openSession()) {
            Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
            return query.list();
        }
    }

    @Override
    public List<Department> getDepartmentByEmployeeId(Long employeeId) {
        try (Session session = factory.openSession()) {
            Query<Department> query = session.createQuery("SELECT e.department FROM Employee e WHERE e.id = :empId", Department.class);
            query.setParameter("empId", employeeId);
            return query.list();
        }
    }
}
