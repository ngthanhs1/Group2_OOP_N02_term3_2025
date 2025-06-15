package com.example.springboot;

import com.example.springboot.CRUD.ListChung;
import com.example.springboot.Model.Room;

import java.util.Scanner;

public class TestRoom {
    private final ListChung<Room> dsRoom = new ListChung<>();
    private final Scanner sc = new Scanner(System.in);

    public TestRoom() {
        dsRoom.setHienThongBao(false);
        dsMauRoom();
    }
    public void dsMauRoom() {
        dsRoom.them(new Room("R01", "Phòng khám 1", "BS.Nguyễn Văn Anh"));
        dsRoom.them(new Room("R02", "Phòng khám 2", "Bs.Trần Thị Bình"));
        dsRoom.them(new Room("R03", "Phòng khám 3", "BS.Lê Văn Cương"));
        dsRoom.them(new Room("R04", "Phòng khám 4", "BS.Trần Văn Dũng"));
        dsRoom.them(new Room("R05", "Phòng khám 5", "BS.Trịnh Văn An"));
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
