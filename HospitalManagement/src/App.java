
import HospitalManagement.Test.TestBenhan;
import HospitalManagement.Test.TestPatient;


public class App {
  public static void main(String[] args) throws Exception {
  System.out.println("chao ca nha iu<>");

  // TestPatient tpt = new TestPatient();
  // tpt.addPatientByInput();
  // tpt.display();

  TestBenhan tba = new TestBenhan();
  tba.addBenhanByInput();
  tba.inDanhSachBenhAn();

  }

}
