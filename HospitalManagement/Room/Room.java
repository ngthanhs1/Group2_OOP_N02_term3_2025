package HospitalManagement.Room;

import HospitalManagement.CRUD.CoId;

public class Room implements CoId{
    private String id;
    private String name;

    public Room(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

     @Override
    public String toString() {
        return String.format("Mã phòng: %s | Tên phòng: %s", id, name);
    }
}
