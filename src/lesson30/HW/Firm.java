package lesson30.HW;

import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class Firm {
    private Date dateFounded;
    private TreeSet<Department> departments = new TreeSet<>();
    private TreeSet<Customer> customers = new TreeSet<>();
}
