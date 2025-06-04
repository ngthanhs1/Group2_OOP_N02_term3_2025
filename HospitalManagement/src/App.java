package HospitalManagement.src;

import HospitalManagement.Test.TestBenhan;
import HospitalManagement.Test.TestPatient;
//import HospitalManagement.Test.TestSchedule;

public class App {
    public static void main(String[] args) throws Exception {
    System.out.println("Chao ca nha iu :3");
    System.out.println();


    TestPatient tpt = new TestPatient();
    tpt.dsMauPatient();
    tpt.inPatient();
    // tpt.addPatient();
    // tpt.updatePatient();
    // tpt.deletePatient();
    // tpt.timKiemPatient();
    TestBenhan tba = new TestBenhan();
    tba.themBenhan();
    tba.inBenhan();

  }
}
