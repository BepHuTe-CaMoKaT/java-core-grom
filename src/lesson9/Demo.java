package lesson9;

public class Demo {
    public static void main(String[] args) {
        User[] users = new User[5];
        User user = new User(1, "andr", "fff05");
        users[0] = user;

        UserRepository userRepository = new UserRepository(users);
        userRepository.getUserNames();
        userRepository.getUserIds();
        userRepository.getUserNameById(5);
        userRepository.getUserByName("Jack");
        userRepository.getUserBySessionId("Jack");
        userRepository.save(user);
    }

}
