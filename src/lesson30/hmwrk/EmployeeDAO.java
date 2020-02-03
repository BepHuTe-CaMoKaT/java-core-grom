package lesson30.hmwrk;

import java.util.TreeSet;

public class EmployeeDAO {
    private static TreeSet<Employee> employeeTreeSet = new TreeSet<>();

    public static Employee add(Employee employee) {
        employeeTreeSet.add(employee);
        return employee;
    }

    public static Employee delete(Employee employee) {
        employeeTreeSet.remove(employee);
        return employee;
    }

    public static TreeSet<Employee> getAll() {
        return employeeTreeSet;
    }

    public static TreeSet<Employee> employeesByProject(String projectName) {
        TreeSet<Employee> Temp = new TreeSet<>();

        for (Employee employee:employeeTreeSet){
            for (Project project:employee.getProjectSet()){
                if (projectName.equals(project.getName()))
                    Temp.add(employee);
            }
        }
        return Temp;
    } //список сотрудников, работающих над заданным проектом

    public static TreeSet<Project> projectsByEmployee(Employee employee){
        TreeSet<Project> projects = new TreeSet<>();
        for (Employee temp:employeeTreeSet){
            if (temp.equals(employee))
                projects.addAll(temp.getProjectSet());
        }
        return projects;
    } //список проектов, в которых участвует заданный сотрудник

    public static TreeSet<Employee> employeesByDepartmentWithoutProject(DepartmentType departmentType) {
        TreeSet<Employee> Temp = new TreeSet<>();
        for (Employee employee:employeeTreeSet){
            if (departmentType.equals(employee.getDepartment().getType())){
                if (employee.getProjectSet().isEmpty())
                    Temp.add(employee);
            }
        }
        return Temp;
    } //список сотрудников из заданного отдела, не участвующих ни в одном проекте

    public static TreeSet<Employee> employeesWithoutProject() {
        TreeSet<Employee> Temp = new TreeSet<>();
        for (Employee temp : employeeTreeSet) {
            if (temp.getProjectSet().isEmpty())
                Temp.add(temp);
        }
        return Temp;
    } //список сотрудников, не участвующих ни в одном проекте

    public static TreeSet<Employee> employeesByTeamLead(Employee lead){
        if (lead.getPosition()!=Position.TEAM_LEAD) return null;
        return new TreeSet<>(employeeTreeSet);
    } //список подчиненных для заданного руководителя (по всем проектам, которыми он руководит)

    public static TreeSet<Employee> teamLeadsByEmployee(Employee employee) {
        if (employee.getPosition() == Position.TEAM_LEAD) return null;
        TreeSet<Employee> Temp = new TreeSet<>();
        for (Employee employees:employeeTreeSet){
            for (Project project:employees.getProjectSet()){
                if (employees.getPosition()==Position.TEAM_LEAD){
                    for (Project tempProject:employees.getProjectSet()){
                        if (tempProject.equals(project))
                            Temp.add(employees);
                    }
                }
            }
        }
        return Temp;
    } //список руководителей для заданного сотрудника (по всем проектам, в которых он участвует)

    public static TreeSet<Employee> employeesByProjectEmployee(Employee employee) {
        TreeSet<Employee> Temp = new TreeSet<>();
        for (Employee tempEmployee : employeeTreeSet) {
            for (Project tempProject : tempEmployee.getProjectSet()) {
                for (Project project : employee.getProjectSet()) {
                    if (tempProject.equals(project))
                        Temp.add(tempEmployee);

                }
            }
        }
        return Temp;
    } //список сотрудников, участвующих в тех же проектах, что и заданный сотрудник

    public static TreeSet<Project> projectsByCustomer(Customer customer) {
        TreeSet<Project> Temp = new TreeSet<>();
        for (Employee tempEmployee : employeeTreeSet) {
            for (Project projectTemp : tempEmployee.getProjectSet()) {
                if (projectTemp.getCustomer().equals(customer))
                    Temp.add(projectTemp);

            }
        }
        return Temp;
    } //список проектов, выполняемых для заданного заказчика

    public static TreeSet<Employee> employeesByCustomerProjects(Customer customer) {
        TreeSet<Employee> Temp = new TreeSet<>();
        for (Employee tempEmployee : employeeTreeSet) {
            for (Project projectTemp : tempEmployee.getProjectSet()) {
                if (projectTemp.getCustomer().equals(customer))
                    Temp.add(tempEmployee);
            }
        }
        return Temp;
    } //список сотрудников, участвующих в проектах, выполняемых для заданного заказчика
}
