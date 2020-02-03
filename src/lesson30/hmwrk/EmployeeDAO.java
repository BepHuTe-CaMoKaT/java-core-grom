package lesson30.hmwrk;

import java.util.Iterator;
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
        Iterator<Employee> employeeIterator = EmployeeDAO.getAll().iterator();
        TreeSet<Employee> Temp = new TreeSet<>();

        while (employeeIterator.hasNext()) {
            Employee employee = employeeIterator.next();
            for (Project project : employee.getProjectSet()) {
                if (project.getName().equals(projectName)) {
                    Temp.add(employee);
                }
            }
        }
        return Temp;
    } //список сотрудников, работающих над заданным проектом
}
