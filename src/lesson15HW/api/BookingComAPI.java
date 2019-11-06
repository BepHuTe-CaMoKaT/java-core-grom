package lesson15HW.api;

public class BookingComAPI implements API {
    Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (Room room : rooms) {
            if (room.getPersons() == persons && room.getPrice() >= price - 100 && room.getPrice() <= price + 100 && room.getCityName() == city && room.getHotelName() == hotel) {
                count++;
            }
        }
        Room[] res = new Room[count];
        int index = 0;
        for (Room room : rooms) {
            if (room.getPersons() == persons && room.getPrice() >= price - 100 && room.getPrice() <= price + 100 && room.getCityName() == city && room.getHotelName() == hotel) {
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
        for (Room room:rooms){
            if (room!=null){
                res[index] = room;
                index++;
            }
        }
        return res;
    }

}
