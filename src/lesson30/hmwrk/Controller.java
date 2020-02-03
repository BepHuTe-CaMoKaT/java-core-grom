package lesson30.hmwrk;

import java.util.Iterator;
import java.util.TreeSet;

public class Controller {

    public static TreeSet<Employee> employeesByProject(String projectName) {
        return EmployeeDAO.employeesByProject(projectName);
    }

    private static void checkProjectForExisting(String projectName){

    }
}
