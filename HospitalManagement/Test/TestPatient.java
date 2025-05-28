package HospitalManagement.Test;

import HospitalManagement.Patientt.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestPatient {
    ArrayList<Patient> pl = new ArrayList<>();

    public ArrayList<Patient> addList() {
        Patient p1 = new Patient("BN001", "Nguyen Thi Lan",
                new GregorianCalendar(1995, Calendar.MARCH, 10),
                "Nữ", "Hà Nội", "0123456789", "Không có tiền sử bệnh");

        Patient p2 = new Patient("BN002", "Tran Van Nam",
                new GregorianCalendar(1999, Calendar.APRIL, 5),
                "Nam", "Hải Phòng", "0987654321", "Tiểu đường");

        Patient p3 = new Patient("BN003", "Le Hoang Nam",new GregorianCalendar(1988, Calendar.JULY, 20),
        "Nam", "Đà Nẵng", "0911222333", "Cao huyết áp");

        pl.add(p1);
        pl.add(p2);
        pl.add(p3);
        return pl;
    }

    public void testEditDelete() {
        PatientList patientList = new PatientList();
        ArrayList<Patient> list = addList();

        for (Patient p : list) {
            patientList.addPatient(p);
        }

        try (Scanner pt = new Scanner(System.in)) {

            System.out.print("Nhập ID bệnh nhân cần cập nhật: ");
            String id = pt.nextLine();

            System.out.print("Nhập tên mới cho bệnh nhân: ");
            String newName = pt.nextLine();

            patientList.editPatient(id, newName);
            System.out.println();

            System.out.println("Danh sách sau khi cập nhật:");
            patientList.printPatientList();

            System.out.print("Nhập ID bệnh nhân cần xoá: ");
            String deleteId = pt.nextLine();

            patientList.deletePatient(deleteId);
        }
        System.out.println();
        System.out.println("Danh sách sau khi xoá:");
        patientList.printPatientList();
    }

    public void indanhsachPatient() {
        ArrayList<Patient> list = addList();
        for (Patient p : list) {
            System.out.println(p);
        }
    }
    public void addPatientByInput() {
    Scanner snr = new Scanner(System.in);
    PatientList patientList = new PatientList();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    sdf.setLenient(false);

    System.out.print("Nhập số lượng bệnh nhân muốn thêm: ");
    int n = Integer.parseInt(snr.nextLine());

    for (int i = 0; i < n; i++) {
        System.out.println("\nNhập thông tin bệnh nhân thứ " + (i + 1));

        System.out.print("Mã BN: ");
        String id = snr.nextLine();

        System.out.print("Họ tên: ");
        String name = snr.nextLine();

        Calendar dob = null;
        while (dob == null) {
            try {
                System.out.print("Ngày sinh (dd/MM/yyyy): ");
                String dobStr = snr.nextLine().trim();
                String[] parts = dobStr.split("/");
                if (parts.length != 3) {
                    throw new Exception("Định dạng không đúng.");
                }
                if (parts[0].length() == 1) parts[0] = "0" + parts[0];
                if (parts[1].length() == 1) parts[1] = "0" + parts[1];

                String formattedDobStr = parts[0] + "/" + parts[1] + "/" + parts[2];

                java.util.Date parsedDate = sdf.parse(formattedDobStr);
                dob = Calendar.getInstance();
                dob.setTime(parsedDate);
            } catch (Exception e) {
                System.out.println("Định dạng không hợp lệ. Vui lòng nhập lại (dd/MM/yyyy).");
            }
        }

        System.out.print("Giới tính: ");
        String gender = snr.nextLine();

        System.out.print("Địa chỉ: ");
        String address = snr.nextLine();

        System.out.print("Số điện thoại: ");
        String phone = snr.nextLine();

        System.out.print("Tiền sử bệnh: ");
        String medicalHistory = snr.nextLine();

        Patient p = new Patient(id, name, dob, gender, address, phone, medicalHistory);
        patientList.addPatient(p);
    }

    System.out.println("\nDanh sách bệnh nhân vừa thêm:");
    patientList.printPatientList();
}


}
