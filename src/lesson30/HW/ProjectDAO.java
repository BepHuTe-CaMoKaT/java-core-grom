package lesson30.HW;

import java.util.TreeSet;

public class ProjectDAO {


    private  TreeSet<Project> projectSet = new TreeSet<>();


    public void add(Project p) {
        projectSet.add(p);
    }

    public  TreeSet<Project> getAll() {
        return projectSet;
    }

    public void print() {
        for (Project project : projectSet) {
            System.out.println(project);

        }

    }
}
