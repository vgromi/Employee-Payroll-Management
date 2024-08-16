package com.Employee_Payroll_Management.Employee_Payroll_Management;
import com.Employee_Payroll_Management.entities.*;
import com.Employee_Payroll_Management.serviceimp.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class MainApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SessionFactory factory = new Configuration().configure().buildSessionFactory();
    private static final EmployeeService employeeService = new EmployeeService(factory);
    private static final PayrollService payrollService = new PayrollService(factory);
    private static final CompanyService companyService = new CompanyService(factory);
    private static final DepartmentService departmentService = new DepartmentService(factory);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Employee Operations");
            System.out.println("2. Payroll Operations");
            System.out.println("3. Company Operations");
            System.out.println("4. Department Operations");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    employeeOperations();
                    break;
                case 2:
                    payrollOperations();
                    break;
                case 3:
                    companyOperations();
                    break;
                case 4:
                    departmentOperations();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
        factory.close(); //close the SessionFactory
    }

    private static void employeeOperations() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nEmployee Operations:");
            System.out.println("1. Add Employee");
            System.out.println("2. Delete Employee");
            System.out.println("3. Update Employee");
            System.out.println("4. View Employee");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    deleteEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    viewEmployee();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addEmployee() {
        System.out.println("Enter employee name:");
        String name = scanner.nextLine();
        System.out.println("Enter employee mobile number:");
        String mobileNo = scanner.nextLine();
        System.out.println("Enter employee date of birth (yyyy-MM-dd):");
        String dobString = scanner.nextLine();
        Date dob = parseDate(dobString);
        System.out.println("Enter employee state:");
        String state = scanner.nextLine();
        System.out.println("Enter employee city:");
        String city = scanner.nextLine();
        System.out.println("Enter employee date of joining (yyyy-MM-dd):");
        String dojString = scanner.nextLine();
        // Parse date of joining
        Date doj = parseDate(dojString);

        Employee employee = new Employee(name, mobileNo, dob, state, city, doj);
        employeeService.insertEmployee(employee);
        System.out.println("Employee added successfully.");
    }

    private static Date parseDate(String dateString) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parsedDate = dateFormat.parse(dateString);
            return new Date(parsedDate.getTime());
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
            return null;
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter employee ID to delete: ");
        long empIdToDelete = scanner.nextLong();
        employeeService.deleteEmployeeById(empIdToDelete);
        System.out.println("Employee deleted successfully.");
    }

    private static void updateEmployee() {
        System.out.print("Enter employee ID to update: ");
        long empIdToUpdate = scanner.nextLong();
        scanner.nextLine();

        Employee employee = employeeService.viewEmployeeById(empIdToUpdate);

        if (employee != null) {
            System.out.println("Enter new name:");
            String newName = scanner.nextLine();
            System.out.println("Enter new mobile number:");
            String newMobileNo = scanner.nextLine();
            System.out.println("Enter new date of birth (yyyy-MM-dd):");
            String newDobString = scanner.nextLine();
            Date newDob = parseDate(newDobString);
            System.out.println("Enter new state:");
            String newState = scanner.nextLine();
            System.out.println("Enter new city:");
            String newCity = scanner.nextLine();
            System.out.println("Enter new date of joining (yyyy-MM-dd):");
            String newDojString = scanner.nextLine();
            Date newDoj = parseDate(newDojString);

            employee.setName(newName);
            employee.setMobileNo(newMobileNo);
            employee.setDob(newDob);
            employee.setState(newState);
            employee.setCity(newCity);
            employee.setDoj(newDoj);

            employeeService.updateEmployee(employee);

            System.out.println("Employee with ID " + empIdToUpdate + " updated successfully.");
        } else {
            System.out.println("Employee with ID " + empIdToUpdate + " not found.");
        }
    }

    private static void viewEmployee() {
        System.out.print("Enter employee ID to view: ");
        long empIdToView = scanner.nextLong();
        scanner.nextLine();

        Employee employee = employeeService.viewEmployeeById(empIdToView);

        if (employee != null) {
            System.out.println("Employee Details:");
            System.out.println("ID: " + employee.getId());
            System.out.println("Name: " + employee.getName());
            System.out.println("Mobile Number: " + employee.getMobileNo());
            System.out.println("Date of Birth: " + employee.getDob());
            System.out.println("State: " + employee.getState());
            System.out.println("City: " + employee.getCity());
            System.out.println("Date of Joining: " + employee.getDoj());
        } else {
            System.out.println("Employee with ID " + empIdToView + " not found.");
        }
    }

    private static void payrollOperations() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nPayroll Operations:");
            System.out.println("1. Add Payroll Record");
            System.out.println("2. Delete Payroll Record");
            System.out.println("3. Update Payroll Record");
            System.out.println("4. View Payroll Record");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addPayrollRecord();
                    break;
                case 2:
                    deletePayrollRecord();
                    break;
                case 3:
                    updatePayrollRecord();
                    break;
                case 4:
                    viewPayrollRecord();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addPayrollRecord() {
        System.out.println("Enter employee ID:");
        Long employeeId = scanner.nextLong();
        scanner.nextLine(); 

        Employee employee = employeeService.viewEmployeeById(employeeId);

        if (employee == null) {
            System.out.println("Employee with ID " + employeeId + " not found.");
            return;
        }

        System.out.println("Enter net salary:");
        Double netSalary = scanner.nextDouble();
        scanner.nextLine(); 

        System.out.println("Enter salary year:");
        String salaryYear = scanner.nextLine();

        System.out.println("Enter gross salary:");
        Double grossSalary = scanner.nextDouble();
        scanner.nextLine();

        Payroll payroll = new Payroll(null, employee, netSalary, salaryYear, grossSalary);
        payrollService.insertPayroll(payroll);
        System.out.println("Payroll record added successfully.");
    }

    private static void deletePayrollRecord() {
        System.out.print("Enter payroll record ID to delete: ");
        int payrollIdToDelete = scanner.nextInt();
        scanner.nextLine(); 

        payrollService.deletePayrollById(payrollIdToDelete);
        System.out.println("Payroll record with ID " + payrollIdToDelete + " deleted successfully.");
    }

    private static void updatePayrollRecord() {
        System.out.print("Enter payroll record ID to update: ");
        int payrollIdToUpdate = scanner.nextInt();
        scanner.nextLine(); 

        Payroll payroll = payrollService.viewPayrollById(payrollIdToUpdate);

        if (payroll != null) {
            System.out.println("Enter new net salary:");
            double netSalary = scanner.nextDouble();
            scanner.nextLine(); 
            System.out.println("Enter new salary year:");
            String salaryYear = scanner.nextLine();
            System.out.println("Enter new gross salary:");
            double grossSalary = scanner.nextDouble();
            scanner.nextLine(); 

            payroll.setNetSalary(netSalary);
            payroll.setSalaryYear(salaryYear);
            payroll.setGrossSalary(grossSalary);

            payrollService.updatePayroll(payroll);

            System.out.println("Payroll record with ID " + payrollIdToUpdate + " updated successfully.");
        } else {
            System.out.println("Payroll record with ID " + payrollIdToUpdate + " not found.");
        }
    }

    private static void viewPayrollRecord() {
        System.out.print("Enter payroll record ID to view: ");
        int payrollIdToView = scanner.nextInt();
        scanner.nextLine(); 

        Payroll payroll = payrollService.viewPayrollById(payrollIdToView);

        if (payroll != null) {
            System.out.println("Payroll Record Details:");
            System.out.println("ID: " + payroll.getId());
            System.out.println("Employee ID: " + payroll.getEmployee().getId());
            System.out.println("Net Salary: " + payroll.getNetSalary());
            System.out.println("Salary Year: " + payroll.getSalaryYear());
            System.out.println("Gross Salary: " + payroll.getGrossSalary());
        } else {
            System.out.println("Payroll record with ID " + payrollIdToView + " not found.");
        }
    }

    private static void companyOperations() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nCompany Operations:");
            System.out.println("1. Add Company");
            System.out.println("2. Delete Company");
            System.out.println("3. Update Company");
            System.out.println("4. View Company");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCompany();
                    break;
                case 2:
                    deleteCompany();
                    break;
                case 3:
                    updateCompany();
                    break;
                case 4:
                    viewCompany();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCompany() {
        System.out.println("Enter company name:");
        String com_name = scanner.nextLine();
        System.out.println("Enter company contact number:");
        String com_mob = scanner.nextLine();
        System.out.println("Enter company address:");
        String com_address = scanner.nextLine();

        Company company = new Company(com_name,com_mob,com_address);
        companyService.insertCompany(company);
        System.out.println("Company added successfully.");
    }

    private static void deleteCompany() {
        System.out.print("Enter company ID to delete: ");
        long companyIdToDelete = scanner.nextLong();
        companyService.deleteCompanyById(companyIdToDelete);
        System.out.println("Company deleted successfully.");
    }

    private static void updateCompany() {
        System.out.print("Enter company ID to update: ");
        long companyIdToUpdate = scanner.nextLong();
        scanner.nextLine(); 

        Company company = companyService.viewCompanyById(companyIdToUpdate);

        if (company != null) {
            System.out.println("Enter new company name:");
            String newName = scanner.nextLine();
            System.out.println("Enter new company contact number:");
            String newContactNo = scanner.nextLine();
            System.out.println("Enter new company address:");
            String newAddress = scanner.nextLine();

            company.setCom_name(newName);
            company.setCom_mob(newContactNo);
            company.setCom_address(newAddress);

            companyService.updateCompany(company);

            System.out.println("Company with ID " + companyIdToUpdate + " updated successfully.");
        } else {
            System.out.println("Company with ID " + companyIdToUpdate + " not found.");
        }
    }

    private static void viewCompany() {
        System.out.print("Enter company ID to view: ");
        long companyIdToView = scanner.nextLong();
        scanner.nextLine();

        Company company = companyService.viewCompanyById(companyIdToView);

        if (company != null) {
            System.out.println("Company Details:");
            System.out.println("ID: " + company.getCom_id());
            System.out.println("Name: " + company.getCom_name());
            System.out.println("Contact Number: " + company.getCom_mob());
            System.out.println("Address: " + company.getCom_address());
        } else {
            System.out.println("Company with ID " + companyIdToView + " not found.");
        }
    }

    private static void departmentOperations() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\nDepartment Operations:");
            System.out.println("1. Add Department");
            System.out.println("2. Delete Department");
            System.out.println("3. Update Department");
            System.out.println("4. View Department");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDepartment();
                    break;
                case 2:
                    deleteDepartment();
                    break;
                case 3:
                    updateDepartment();
                    break;
                case 4:
                    viewDepartment();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addDepartment() {
        System.out.println("Enter department name:");
        String name = scanner.nextLine();
        
        System.out.println("Enter company ID:");
        long companyId = scanner.nextLong();
        scanner.nextLine();

        Company company = companyService.viewCompanyById(companyId);
        Department department = new Department(name, company); // Use 'name' instead of 'depName'
        departmentService.insertDepartment(department);

        System.out.println("Department added successfully.");
    }

    private static void deleteDepartment() {
        System.out.print("Enter department ID to delete: ");
        long departmentIdToDelete = scanner.nextLong();
        departmentService.deleteDepartmentById(departmentIdToDelete);
        System.out.println("Department deleted successfully.");
    }

    private static void updateDepartment() {
        System.out.print("Enter department ID to update: ");
        long departmentIdToUpdate = scanner.nextLong();
        scanner.nextLine(); 

        Department department = departmentService.viewDepartmentById(departmentIdToUpdate);

        if (department != null) {
            System.out.println("Enter new department name:");
            String newName = scanner.nextLine();

            department.setDep_name(newName);

            departmentService.updateDepartment(department);

            System.out.println("Department with ID " + departmentIdToUpdate + " updated successfully.");
        } else {
            System.out.println("Department with ID " + departmentIdToUpdate + " not found.");
        }
    }

    private static void viewDepartment() {
        System.out.print("Enter department ID to view: ");
        long departmentIdToView = scanner.nextLong();
        scanner.nextLine();

        Department department = departmentService.viewDepartmentById(departmentIdToView);

        if (department != null) {
            System.out.println("Department Details:");
            System.out.println("ID: " + department.getDep_id());
            System.out.println("Name: " + department.getDep_name());
            System.out.println("Company ID: " + department.getCompany().getCom_id());
        } else {
            System.out.println("Department with ID " + departmentIdToView + " not found.");
        }
    }
}
