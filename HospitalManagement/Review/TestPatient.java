package HospitalManagement.Review;

import HospitalManagement.Patientt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TestPatient {
    ArrayList<Patient> pl = new ArrayList<>();

    public ArrayList<Patient> addList(){
        Patient p1 = new Patient("BN001", "Nguyen Thi Lan",
                new GregorianCalendar(1995, Calendar.MARCH, 10),
                "Nữ", "Hà Nội", "0123456789", "Không có tiền sử bệnh");

        Patient p2 = new Patient("BN002", "Tran Van Nam",
                new GregorianCalendar(1999, Calendar.APRIL, 5),
                "Nam", "Hải Phòng", "0987654321", "Tiểu đường");

        Patient p3 = new Patient("BN003", "Le Hoang Nam",
                new GregorianCalendar(1988, Calendar.JULY, 20),
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
            // Cập nhật tên bệnh nhân
            System.out.print("Nhập ID bệnh nhân cần cập nhật: ");
            String id = pt.nextLine();

            System.out.print("Nhập tên mới cho bệnh nhân: ");
            String newName = pt.nextLine();

            patientList.editPatient(id, newName);

            // In danh sách sau khi cập nhật
            System.out.println("Danh sách sau khi cập nhật:");
            patientList.printPatientList();

            // Xoá bệnh nhân
            System.out.print("Nhập ID bệnh nhân cần xoá: ");
            String deleteId = pt.nextLine();

            patientList.deletePatient(deleteId);
        }

        System.out.println("Danh sách sau khi xoá:");
        patientList.printPatientList();
    }

    public void testDelete(PatientList patientList, String patientID) {
        patientList.deletePatient(patientID);
        patientList.printPatientList();
    }
    public void display(){
         for (int i =0 ; i< pl.size(); i++)
        {
          // System.out.println("test: " + pl.get(i).getName());
        }
    }
}
