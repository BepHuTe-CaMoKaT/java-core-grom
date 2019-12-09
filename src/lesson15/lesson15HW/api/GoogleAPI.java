package lesson15.lesson15HW.api;

public class GoogleAPI implements API {
    Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (Room room : rooms) {
            if (room.equals(new Room(price,persons,city,hotel))) {
                count++;
            }
        }
        Room[] res = new Room[count];
        int index = 0;
        for (Room room : rooms) {
            if (room.equals(new Room(price, persons, city, hotel))) {
                res[index] = room;
                index++;
            }

        }
        return res;
    }

    @Override
    public Room[] getAll() {
        int count = 0;
        for (Room room : rooms) {
            if (room != null) {
                count++;
            }
        }
        int index = 0;
        Room[] res = new Room[count];
        for (Room room : rooms) {
            if (room != null) {
                res[index] = room;
                index++;
            }
        }
        return res;
    }
}
