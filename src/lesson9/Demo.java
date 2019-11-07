package lesson9;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User[] users = new User[5];
        User user = new User(1, "andr", "fff05");
        users[0] = user;

        UserRepository userRepository = new UserRepository(users);
        System.out.println(Arrays.toString(userRepository.getUserNames()));
        System.out.println(Arrays.toString(userRepository.getUserIds()));
        System.out.println(userRepository.getUserNameById(1));
        System.out.println(userRepository.getUserByName("andr"));
        System.out.println(userRepository.getUserBySessionId("fff05"));
        System.out.println(userRepository.save(user));
    }

}
