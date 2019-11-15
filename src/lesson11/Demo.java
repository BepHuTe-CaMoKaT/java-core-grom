package lesson11;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Room[] rooms =new Room[5];
        Room room = new Room(1001,500,4,new Date(),"City","Hotel");
        Room room1 = new Room(1002,400,3,new Date(),"City","Hotel");
        rooms[0]=room;
        rooms[1]=room1;

        BookingComAPI bookingComAPI = new BookingComAPI(rooms);
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI(rooms);
        GoogleAPI googleAPI = new GoogleAPI(rooms);


        Controller controller = new Controller();
        System.out.println(Arrays.toString(controller.check(tripAdvisorAPI,googleAPI)));
        System.out.println(Arrays.toString(googleAPI.getAll()));

    }



}


