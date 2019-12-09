package lesson15.lesson15HW.api;

public class Controller {
    API[] apis;

    public Controller(API[] apis) {
        this.apis = apis;
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
                if (room.equals(room1)) count++;
        }
        }
        Room[] res = new Room[count];
        int index = 0;
            for (Room room1 : api1.getAll()) {
                for (Room room2 : api2.getAll()) {
                    if (room1.equals(room2)){
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
