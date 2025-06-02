package HospitalManagement.Test;

import HospitalManagement.CRUD.ListChung;
import HospitalManagement.Room.Doctor;
import java.util.Scanner;

public class TestDoctor {
    private final ListChung<Doctor> dsDoctor = new ListChung<>();
    private final Scanner sc = new Scanner(System.in);

    public TestDoctor() {
        dsMauDoctor();
    }

    public void dsMauDoctor() {
        dsDoctor.them(new Doctor("D01", "Bác sĩ Nguyễn Văn An"));
        dsDoctor.them(new Doctor("D02", "Bác sĩ Trần Thị Bình"));
        dsDoctor.them(new Doctor("D03", "Bác sĩ Lê Văn Cường"));
    }

    public void hienThiDanhSach() {
        System.out.println("=== DANH SÁCH BÁC SĨ ===");
        for (Doctor d : dsDoctor.getList()) {
            System.out.println(d);
        }
    }

    public ListChung<Doctor> getDoctorList() {
        return dsDoctor;
    }
}
