package lesson30.hmwrk;

import lesson30.HW.Employee;
import lesson30.HW.EmployeeDAO;
import lesson30.HW.Project;

import java.util.Iterator;
import java.util.TreeSet;

public class Controller {
    public static TreeSet<lesson30.HW.Employee> employeesByProject(String projectName) {
        Iterator<lesson30.HW.Employee> employeeIterator = EmployeeDAO.getAll().iterator();
        TreeSet<lesson30.HW.Employee> Temp = new TreeSet<>();

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

    private static void checkProjectForExisting(String projectName){

    }
}
