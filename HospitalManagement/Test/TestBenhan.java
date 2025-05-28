package HospitalManagement.Test;

import HospitalManagement.BenhAn.BenhAn;
import HospitalManagement.BenhAn.BenhanList;
import HospitalManagement.Patientt.Patient;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestBenhan {
    // Giữ nguyên theo format của bạn
    private final TestPatient testPatient = new TestPatient();
    private final ArrayList<Patient> dsPatient = testPatient.addList();
    private final BenhanList dsBenhAn = new BenhanList();

     //Tạo danh sách bệnh án mẫu liên kết với bệnh nhân
    public void taoBenhAnMau() {
        dsBenhAn.themBenhAn(new BenhAn("BA001", dsPatient.get(0),new GregorianCalendar(2024, Calendar.JANUARY, 10),
            "Sốt, ho", dsPatient.get(0).getMedicalHistory(), "Cảm cúm"));
            
        dsBenhAn.themBenhAn(new BenhAn("BA002", dsPatient.get(1),new GregorianCalendar(2024, Calendar.MARCH, 12),
            "Khó thở", dsPatient.get(1).getMedicalHistory(), "Viêm phổi"));

        dsBenhAn.themBenhAn(new BenhAn("BA003", dsPatient.get(2),new GregorianCalendar(2024, Calendar.APRIL, 25),
            "Đau đầu", dsPatient.get(2).getMedicalHistory(), "Thiếu máu não"));
    }
    public void inDanhSachBenhAn() {
        dsBenhAn.inDanhSachBenhAn();
    }
    public void testSuaBenhAn() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID bệnh án cần sửa: ");
        String id = sc.nextLine();
        System.out.print("Nhập chẩn đoán mới: ");
        String cd = sc.nextLine();
        dsBenhAn.suaBenhAn(id, cd);
    }
    public void testXoaBenhAn() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập ID bệnh án cần xoá: ");
        String id = sc.nextLine();
        dsBenhAn.xoaBenhAn(id);
    }
}
