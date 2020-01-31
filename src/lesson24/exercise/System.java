package lesson24.exercise;

public class System {
    private int filesCount;
    private String location;

    public System(int filesCount, String location) {
        this.filesCount = filesCount;
        this.location = location;
    }

    @Override
    public String toString() {
        return "System{" +
                "filesCount=" + filesCount +
                ", location='" + location + '\'' +
                '}';
    }
}
