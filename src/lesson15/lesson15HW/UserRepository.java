package lesson15.lesson15HW;

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
        if (findById(user.getId())!=null)
            return null;
        for (User us:users){
                if (us==null) return users[index]=user;
            index++;
        }
        return null;
    }

    public User update(User user){
        int index=0;
        for (User us:users){
            if (us!=null&&us.getId()==user.getId()&&!us.equals(user)) {
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
            if (us!=null&&us.getId()==user.getId()) return user;
        }
        return null;
    }

    private User findById(long id) {
        for (User user : users) {
            if (user != null && user.getId() == id) return user;
        }
        return null;
    }
}
