package lesson30.hmwrk;

import java.util.TreeSet;

public class ProjectDAO {

    private  TreeSet<Project> projectSet = new TreeSet<>();

    public void add(Project p) {
        projectSet.add(p);
    }

    public  TreeSet<Project> getAll() {
        return projectSet;
    }

}
