package lesson15HW;

public class UserRepository {
    User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public User save(User user){
        int index = 0;
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
            if (us!=null && us.equals(user)){
                users[index]=user;
                return users[index];
            }
            index++;
        }
        return null;
    }

    public void delete(long id){
        int index=0;
        for (User user : users) {
            if (user != null && user.getId() == id){
                users[index]=null;
            }
        }
    }

    public User findUser(User user){
        for (User us:users){
            if (us.hashCode()==user.hashCode()) return user;
        }
        return null;
    }
}
