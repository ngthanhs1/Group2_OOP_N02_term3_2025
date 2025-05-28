package HospitalManagement.src;

import HospitalManagement.Test.TestBenhan;
import HospitalManagement.Test.TestPatient;

public class App {
    public static void main(String[] args) throws Exception {
    System.out.println("chao ca nha iu<>");
    System.out.println();

    TestPatient tpt = new TestPatient();
    tpt.themDanhSachMau();
    tpt.addPatient();
    tpt.inPatient();

    // TestBenhan tba = new TestBenhan();
    // tba.addBenhAn();
    // tba.inBenhAn();
    // tba.updateBenhAn();
    // tba.inBenhAn();

//   TestSchedule tse = new TestSchedule();
//   tse.khoitaoBAPT();
//   tse.inDanhSachSchedule();
//   tse.timKiem();
//   tse.xoaSchedule();
//   tse.inDanhSachSchedule();

  }
}
