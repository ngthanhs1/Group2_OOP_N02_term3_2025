package HospitalManagement.src;

import HospitalManagement.Test.TestBenhan;
import HospitalManagement.Test.TestPatient;
import HospitalManagement.Test.TestSchedule;

public class App {
    public static void main(String[] args) throws Exception {
    System.out.println("Chao ca nha iu :3");
    System.out.println();

    // TestPatient tpt = new TestPatient();
    // tpt.themDanhSachMau();
    // tpt.addPatient();
    // tpt.inPatient();

    // TestPatient tpt = new TestPatient();
    // tpt.themDanhSachMau();
    // TestBenhan tba = new TestBenhan(tpt);
    // tba.themBenhAn();
    // tba.inBenhAn();

    TestPatient tpt = new TestPatient();
    tpt.themDanhSachMau();
    tpt.inPatient();
    TestBenhan tbn = new TestBenhan(tpt);
    tbn.themBenhAn();
    TestSchedule tse = new TestSchedule(tpt, tbn);
    tse.themSchedule();
    tse.inSchedule();
    
  }
}
