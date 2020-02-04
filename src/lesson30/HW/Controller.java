package lesson30.HW;

import java.util.TreeSet;

public class Controller {

    public static TreeSet<Employee> employeesByProject(String projectName) {
        return EmployeeDAO.employeesByProject(projectName);
    }


    public static TreeSet<Project> projectsByEmployee(Employee employee) {
        return EmployeeDAO.projectsByEmployee(employee);
    }

    public static TreeSet<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        return EmployeeDAO.employeesByDepartmentWithoutProject(departmentType);
    }


    public static TreeSet<Employee> employeesWithoutProject() {
        return EmployeeDAO.employeesWithoutProject();
    }


    public static TreeSet<Employee> employeesByTeamLead(Employee lead) {

        return EmployeeDAO.employeesByTeamLead(lead);
    }


    public static TreeSet<Employee> teamLeadsByEmployee(Employee employee) {
        return EmployeeDAO.teamLeadsByEmployee(employee);
    }


    public static TreeSet<Employee> employeesByProjectEmployee(Employee employe) {
        return EmployeeDAO.employeesByProjectEmployee(employe);
    }


    public static TreeSet<Project> projectsByCustomer(Customer customer) {
        return EmployeeDAO.projectsByCustomer(customer);
    }

    public static TreeSet<Employee> employeesByCustomerProjects(Customer customer) {
        return EmployeeDAO.employeesByCustomerProjects(customer);

    }


}
