package lesson11;

public class GoogleAPI implements API {
    Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (Room room : rooms) {
            if (room.getPersons() == persons && room.getPrice() == price && room.getCityName() == city && room.getHotelName() == hotel) {
                count++;
            }
        }
        Room[] res = new Room[count];
        int index = 0;
        for (Room room : rooms) {
            if (room.getPersons() == persons && room.getPrice() == price && room.getCityName() == city && room.getHotelName() == hotel) {
                res[index] = room;
                index++;
            }
        }
        return res;
    }

    @Override
    public Room[] getAll() {int count = 0;
        for (Room room : rooms) {
            if (room != null) {
                count++;
            }
        }
        int index = 0;
        Room[] res = new Room[count];
        for (Room room:rooms){
            if (room!=null){
                res[index] = room;
                index++;
            }
        }
        return res;
    }
}
