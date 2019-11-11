package lesson11;

public class Controller {
    API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
    }

    public Controller() {

    }

    Room[] requestRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (API api : apis) {
            if (api.findRooms(price, persons, city, hotel) != null) count++;
        }
        Room[] res = new Room[count];
        int index = 0;
        for (Room room : res) {
            if (room != null) {
                res[index] = room;
                index++;
            }
        }
        return res;
    }

    Room[] check(API api1, API api2) {
        int count = 0;
        for (Room room : api1.getAll()) {
            for (Room room1 : api2.getAll()) {
                if (room.getPrice() == room1.getPrice() && room.getPersons() == room1.getPersons() && room.getHotelName() == room1.getHotelName() && room.getCityName() == room1.getCityName()) count++;
            }
        }
        Room[] res = new Room[count];
        int index = 0;
            for (Room room1 : api1.getAll()) {
                for (Room room2 : api2.getAll()) {
                    if (room1.getPrice() == room2.getPrice() && room1.getPersons() == room2.getPersons() && room1.getHotelName() == room2.getHotelName() && room1.getCityName() == room2.getCityName()){
                        res[index] = room1;
                        index++;
                    }

                }

            }
        return res;
    }
    Room cheapestRoom () {
        Room cheapest = new Room();
        for (API api : apis) {
            for (Room room:api.getAll()){
                if (room.getPrice()<cheapest.getPrice()){
                    cheapest=room;
                }
            }


        }
        return cheapest;
    }
}
