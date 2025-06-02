package HospitalManagement.Test;

import HospitalManagement.CRUD.ListChung;
import HospitalManagement.Room.Room;
import java.util.Scanner;

public class TestRoom {
    private final ListChung<Room> dsRoom = new ListChung<>();
    private final Scanner sc = new Scanner(System.in);

    public TestRoom() {
        dsMauRoom();
    }

    public void dsMauRoom() {
        dsRoom.them(new Room("R01", "Phòng khám Nội"));
        dsRoom.them(new Room("R02", "Phòng khám Ngoại"));
        dsRoom.them(new Room("R03", "Phòng khám Nhi"));
    }

    public void hienThiDanhSach() {
        System.out.println("=== DANH SÁCH PHÒNG KHÁM ===");
        for (Room r : dsRoom.getList()) {
            System.out.println(r);
        }
    }

    public ListChung<Room> getRoomList() {
        return dsRoom;
    }
}
