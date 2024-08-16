package com.Employee_Payroll_Management.serviceimp;

import com.Employee_Payroll_Management.entities.Payroll;
import com.Employee_Payroll_Management.service.PayrollInterface;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class PayrollService implements PayrollInterface {

    private final SessionFactory factory;

    public PayrollService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public void insertPayroll(Payroll payroll) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(payroll);
            transaction.commit();
        }
    }

    @Override
    public void deletePayrollById(int payrollId) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Payroll payroll = session.get(Payroll.class, (long) payrollId);
            if (payroll != null) {
                session.delete(payroll);
            }
            transaction.commit();
        }
    }

    @Override
    public void updatePayroll(Payroll payroll) {
        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(payroll);
            transaction.commit();
        }
    }

    @Override
    public Payroll viewPayrollById(int payrollId) {
        try (Session session = factory.openSession()) {
            return session.get(Payroll.class, (long) payrollId);
        }
    }

    @Override
    public List<Payroll> getAllPayrolls() {
        try (Session session = factory.openSession()) {
            Query<Payroll> query = session.createQuery("FROM Payroll", Payroll.class);
            return query.list();
        }
    }

    @Override
    public List<Payroll> getPayrollsByEmployeeId(Long employeeId) {
        try (Session session = factory.openSession()) {
            Query<Payroll> query = session.createQuery("FROM Payroll WHERE employee.id = :empId", Payroll.class);
            query.setParameter("empId", employeeId);
            return query.list();
        }
    }
}
