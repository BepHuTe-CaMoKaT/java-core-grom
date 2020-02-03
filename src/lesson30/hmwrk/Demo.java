package lesson30.hmwrk;

import java.util.Date;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        TreeSet<Employee> employees1 = new TreeSet<>();

        Customer customer1 = new Customer("qq", "UA", 100);
        Customer customer2 = new Customer("ww", "US", 1070);
        Customer customer3 = new Customer("ee", "AU", 10060);
        Customer customer4 = new Customer("rr", "NZ", 155);


        Project project1 = new Project("Q", customer1);
        Project project2 = new Project("W", customer2);
        Project project3 = new Project("E", customer3);
        Project project4 = new Project("R", customer4);


        ProjectDAO project_DAO1 = new ProjectDAO();
        ProjectDAO project_DAO2 = new ProjectDAO();
        ProjectDAO project_DAO3 = new ProjectDAO();
        ProjectDAO project_DAO4 = new ProjectDAO();

        project_DAO1.add(project1);
        project_DAO2.add(project2);
        project_DAO3.add(project3);
        project_DAO4.add(project4);

        Department department1 = new Department(DepartmentType.DESIGNER, employees1);
        Department department2 = new Department(DepartmentType.DESIGNER, employees1);
        Department department3 = new Department(DepartmentType.DESIGNER, employees1);


        Employee employee_1 = new Employee("A", "C", new Date(), Position.DESIGNER, department1, project_DAO1.getAll());
        Employee employee_2 = new Employee("S", "S", new Date(), Position.ANALYST, department2, project_DAO2.getAll());
        Employee employee_3 = new Employee("D", "G", new Date(), Position.TEAM_LEAD, department1, project_DAO3.getAll());
        Employee employee_4 = new Employee("F", "O", new Date(), Position.ANALYST, department3, project_DAO4.getAll());

        EmployeeDAO.add(employee_1);
        EmployeeDAO.add(employee_2);
        EmployeeDAO.add(employee_3);
        EmployeeDAO.add(employee_4);

        System.out.println(Controller.employeesByProject("A"));

        System.out.println(Controller.projectsByEmployee(employee_1));

        System.out.println(Controller.employeesByDepartmentWithoutProject(DepartmentType.DESIGNER));

        System.out.println(Controller.employeesWithoutProject());

        System.out.println(Controller.employeesByTeamLead(employee_3));

        System.out.println(Controller.teamLeadsByEmployee(employee_1));

        System.out.println(Controller.employeesByProjectEmployee(employee_2));

        System.out.println(Controller.projectsByCustomer(customer2));

        System.out.println(Controller.employeesByCustomerProjects(customer2));
    }
}
