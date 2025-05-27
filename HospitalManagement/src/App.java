

import HospitalManagement.Test.TestPatient;


public class App {
  public static void main(String[] args) throws Exception {
  System.out.println("hi");

  TestPatient tpt = new TestPatient();

  tpt.addPatientByInput();

  tpt.display();
  }

}
