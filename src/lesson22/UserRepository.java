package lesson22;

public class UserRepository {

    User[] users;

    private int countUsers() {
        int countUsers = 0;
        for (User user : users) {
            if (user != null) countUsers++;
        }
        return countUsers;
    }


    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        int index = 0;
        String[] names = new String[countUsers()];
        for (User user : users) {
            if (user != null) {
                names[index] = user.getName();
                index++;
            }
        }
        return names;

    }

    public long[] getUserIds() {
        long[] id = new long[countUsers()];
        int index = 0;
        for (User user : users) {
            if (user != null) {
                id[index] = user.getId();
                index++;
            }
        }
        return id;
    }

    public String getUserNameById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id) return user.getName();
        }
        return null;
    }

    public User getUserByName(String name) {
        for (User user : users) {
            if (user != null && user.getName().equals(name)) return user;
        }
        return null;
    }

    private User findById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id) return user;
        }
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        for (User user : users) {
            if (user != null && user.getSessionId().equals(sessionId)) return user;
        }
        return null;
    }

    public User save(User user) {
        int index = 0;
        if (findById(user.getId())!=null)
            return null;

        for (User us:users){
            if (us==null){
                users[index]=user;
                return users[index];
            }
            index++;
        }
        return null;
    }

    public User update(User user){
        int index=0;
        for (User us:users){
            if (us!=null && us.getId()==user.getId()){
                users[index]=user;
                return users[index];
            }
            index++;
        }
        return null;
    }

    void delete(long id){
        int index=0;
        for (User user : users) {
            if (user != null && user.getId() == id){
                users[index]=null;
            }
        }

    }
}