package lesson30.hmwrk;

import java.util.Objects;

public class Project implements Comparable<Project>{
    private String name;
    private Customer customer;



    public Project(String name, Customer customer) {
        this.name = name;
        this.customer = customer;
    }
    public String getName() {
        return name;
    }

    public Customer getCustomer() {
        return customer;
    }


    @Override
    public int compareTo(Project o) {
        return 1;
    }



    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", customer=" + customer +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return name.equals(project.name) &&
                customer.equals(project.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, customer);
    }
}
