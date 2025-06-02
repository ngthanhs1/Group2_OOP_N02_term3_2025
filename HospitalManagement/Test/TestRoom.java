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
        dsRoom.them(new Room("R01", "Phòng khám Nội", "D01", "Nguyễn Văn A"));
        dsRoom.them(new Room("R02", "Phòng khám Ngoại", "D02", "Trần Thị B"));
        dsRoom.them(new Room("R03", "Phòng khám Da liễu", "D03", "Lê Văn C"));
    }

    public void hienThiDanhSach() {
        System.out.println("=== DANH SÁCH PHÒNG KHÁM ===");

        for (Room r : dsRoom.getList()) {
            System.out.printf("Mã phòng: %s | Tên phòng: %s | Bác sĩ phụ trách: %s\n",
                    r.getId(), r.getName(), r.getDoctorName());
        }
    }

    public ListChung<Room> getRoomList() {
        return dsRoom;
    }
}
