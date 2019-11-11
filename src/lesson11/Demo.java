package lesson11;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        BookingComAPI bookingComAPI = new BookingComAPI();
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI();
        GoogleAPI googleAPI = new GoogleAPI();
        System.out.println(Arrays.toString(bookingComAPI.findRooms(100,4,"Sydney","Gold Cost")));
        System.out.println(Arrays.toString(googleAPI.findRooms(150,34,"Silicon Valley","Heaven")));
        System.out.println(Arrays.toString(tripAdvisorAPI.findRooms(3000,4,"Bern","Mountain Due")));

        Controller controller = new Controller();
        System.out.println(Arrays.toString(controller.apis));
        System.out.println(controller.cheapestRoom());
        System.out.println(Arrays.toString(controller.check(tripAdvisorAPI,googleAPI)));
        System.out.println(Arrays.toString(controller.requestRooms(50,2,"City","hotel")));

    }


}


