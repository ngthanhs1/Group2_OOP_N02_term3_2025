package HospitalManagement.src;

import HospitalManagement.Test.TestBenhan;
import HospitalManagement.Test.TestMedicine;
import HospitalManagement.Test.TestPatient;
import HospitalManagement.Test.TestPrescription;
import HospitalManagement.Test.TestQuayThuoc;
//import HospitalManagement.Test.TestSchedule;
import HospitalManagement.Test.TestSchedule;

public class App {
    public static void main(String[] args) throws Exception {
    System.out.println("Chao ca nha iu :3");
    System.out.println();


    TestPatient tpt = new TestPatient();
    tpt.dsMauPatient();
    tpt.inPatient();
    tpt.timKiemPatient();
    // tpt.addPatient();
    // tpt.updatePatient();
    // tpt.deletePatient();
    // tpt.timKiemPatient();
    TestBenhan tba = new TestBenhan();
    tba.themBenhan();
    tba.inBenhan();
    TestSchedule ts = new TestSchedule(tpt, tba);
    ts.themSchedule();
    ts.inSchedule();
    TestMedicine tm = new TestMedicine();
    tm.dsMauThuoc();
    tm.inDanhSachThuoc();
    TestPrescription tp = new TestPrescription(tm);
    tp.themDonThuoc();
    tp.inDonThuoc();
    TestQuayThuoc tqt = new TestQuayThuoc(tp);
    tqt.inThuocTrongDon();
    tqt.timKiemTheoTen();
  }
}
