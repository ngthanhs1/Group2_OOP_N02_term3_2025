package HospitalManagement.Room;

import HospitalManagement.CRUD.CoId;

public class Room implements CoId {
    private String id;
    private String name;
    private String doctorId;
    private String doctorName; // Thêm tên bác sĩ

    public Room(String id, String name, String doctorId, String doctorName) {
        this.id = id;
        this.name = name;
        this.doctorId = doctorId;
        this.doctorName = doctorName;
    }

    // Getter & Setter
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

    public String getDoctorId() {
        return doctorId;
    }
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Override
    public String toString() {
        return String.format(
            "Mã phòng: %s | Tên phòng: %s\nBác sĩ phụ trách: %s (%s)",
            id, name, doctorName, doctorId
        );
    }
}
