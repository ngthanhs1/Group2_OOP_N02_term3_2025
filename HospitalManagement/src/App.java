
import HospitalManagement.Test.TestBenhan;
import HospitalManagement.Test.TestPatient;
import HospitalManagement.Test.TestSchedule;


public class App {
  public static void main(String[] args) throws Exception {
  System.out.println("chao ca nha iu<>");
  System.out.println();

  // TestPatient tpt = new TestPatient();
  // tpt.addPatientByInput();
  // tpt.indanhsachPatient();

  // TestBenhan tba = new TestBenhan();
  // tba.taoBenhAnMau();
  // tba.inDanhSachBenhAn();
  // tba.testSuaBenhAn();
  // tba.inDanhSachBenhAn();

  TestSchedule tse = new TestSchedule();
  tse.khoiTaoMau();
  tse.hienThi();


  }

}
