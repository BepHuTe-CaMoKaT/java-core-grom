package lesson15.lesson15HW.api;

public class TripAdvisorAPI implements API {
    Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int count = 0;
        for (Room room : rooms) {
            if (room.getPersons() >= persons - 1 && room.getPersons() <= persons + 1 && room.getPrice() == price && room.getCityName() == city && room.getHotelName() == hotel) {
                count++;
            }
        }

        Room[] res = new Room[count];
        int index = 0;
        for (Room room : rooms) {
            if (room.getPersons() >= persons - 1 && room.getPersons() <= persons + 1 && room.getPrice() == price && room.getCityName() == city && room.getHotelName() == hotel) {
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
