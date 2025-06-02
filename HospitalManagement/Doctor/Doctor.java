package HospitalManagement.Doctor;

import HospitalManagement.CRUD.CoId;

public class Doctor implements CoId{
    private String id;
    private String name;
    private String chuyennganh;
    private String roomId;

    public Doctor(String id, String name, String chuyennganh, String roomId) {
        this.id = id;
        this.name = name;
        this.chuyennganh = chuyennganh;
        this.roomId = roomId;
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
    public String getChuyennganh() {
        return chuyennganh;
    }
    public void setChuyennganh(String chuyennganh) {
        this.chuyennganh = chuyennganh;
    }
    public String getRoomId() {
        return roomId;
    }
    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    

}
