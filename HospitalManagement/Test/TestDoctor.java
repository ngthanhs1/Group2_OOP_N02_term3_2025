package HospitalManagement.Test;

import HospitalManagement.CRUD.ListChung;
import HospitalManagement.Room.Doctor;

import java.util.Scanner;

public class TestDoctor {
    private static final ListChung<Doctor> dsDoctor = new ListChung<>();
    private final Scanner sc = new Scanner(System.in);

    public TestDoctor() {
        dsDoctor.setHienThongBao(false);
        dsDoctor();
    }
    public void dsDoctor() {
        dsDoctor.them(new Doctor("D01", "BS.Nguyễn Văn Anh"));
        dsDoctor.them(new Doctor("D02", "BS.Trần Thị Bình"));
        dsDoctor.them(new Doctor("D03", "BS.Lê Văn Cường"));
        dsDoctor.them(new Doctor("D04", "BS.Trần Văn Dũng"));
        dsDoctor.them(new Doctor("D05", "BS.Trịnh Văn An"));
    }

    public void hienThiDanhSach() {
        System.out.println("=== DANH SÁCH BÁC SĨ ===");
        for (Doctor d : dsDoctor.getList()) {
            System.out.println(d);
        }
    }

    public static ListChung<Doctor> getDsDoctor() {
        return dsDoctor;
    }

    public ListChung<Doctor> getDoctorList() {
        return dsDoctor;
    }
}
