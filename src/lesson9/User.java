package lesson9;

public class User {
    private long id;
    private String name;
    private String sessionId;


    public User(long id, String name, String sessionId) {
        this.id = id;
        this.name = name;
        this.sessionId = sessionId;
    }

    public User() {
        // TODO Auto-generated constructor stub
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSessionId() {
        return sessionId;
    }
}