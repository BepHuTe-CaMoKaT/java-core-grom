package lesson30.HW;

import java.util.Date;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {
        TreeSet<Employee> employees1 = new TreeSet<>();

        Customer customer1 = new Customer("A", "UA", 10);
        Customer customer2 = new Customer("B", "US", 100);
        Customer customer3 = new Customer("C", "TR", 1000);
        Customer customer4 = new Customer("D", "NG", 1);


        Project project1 = new Project("H1", customer1);
        Project project2 = new Project("H2", customer2);
        Project project3 = new Project("H3", customer3);
        Project project4 = new Project("H4", customer4);


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


        Employee employee_1 = new Employee("X1", "A", new Date(), Position.DESIGNER, department1, project_DAO1.getAll());
        Employee employee_2 = new Employee("X2", "B", new Date(), Position.ANALYST, department2, project_DAO2.getAll());
        Employee employee_3 = new Employee("X3", "C", new Date(), Position.TEAM_LEAD, department1, project_DAO3.getAll());
        Employee employee_4 = new Employee("X4", "D", new Date(), Position.ANALYST, department3, project_DAO4.getAll());


        Employee employee_5 = new Employee("X5", "E", new Date(), Position.ANALYST, department1, project_DAO1.getAll());

        EmployeeDAO.add(employee_1);
        EmployeeDAO.add(employee_2);
        EmployeeDAO.add(employee_3);
        EmployeeDAO.add(employee_4);
        // EmployeeDAO.add(employee_5);

        Department department4 = new Department(DepartmentType.FINANCE, EmployeeDAO.getAll());
        Employee employee0 = new Employee("Sergio", "A", new Date(), Position.DESIGNER, department4, null);
        //   EmployeeDAO.add(employee0);


        //  System.out.println(EmployeeDAO.getAll());

        System.out.println(Controller.employeesByProject("H1"));

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