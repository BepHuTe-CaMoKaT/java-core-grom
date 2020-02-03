package lesson30.hmwrk;

import java.util.Date;
import java.util.Objects;
import java.util.TreeSet;

public class Employee implements Comparable<Employee> {
    private   String firstName;
    private String lastName;
    private Date dateHired;
    private Position position;
    private Department department;
    private TreeSet <Project> projectSet;


    public Employee(String firstName, String lastName, Date dateHired, Position position, Department department, TreeSet<Project> projectSet) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateHired = dateHired;
        this.position = position;
        this.department = department;
        this.projectSet = projectSet;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateHired() {
        return dateHired;
    }

    public Position getPosition() {
        return position;
    }

    public Department getDepartment() {
        return department;
    }

    public TreeSet<Project> getProjectSet() { return projectSet; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                dateHired.equals(employee.dateHired) &&
                position == employee.position &&
                department.equals(employee.department) &&
                projectSet.equals(employee.projectSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateHired, position, department, projectSet);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateHired=" + dateHired +
                ", position=" + position +
                ", projectSet=" + projectSet +
                '}'+ '\n';
    }


    public int compareTo(Employee o) {
        return 1;
    }
}