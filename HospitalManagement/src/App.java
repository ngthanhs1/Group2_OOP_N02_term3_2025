import HospitalManagement.test.TestNumber;
import HospitalManagement.test.TestPatient;
import HospitalManagement.test.TestRandNumber;
import HospitalManagement.test.Testpatient;
import HospitalManagement.src.Time;


public class App {
    public static void main(String[] args) throws Exception {
  System.out.println("hi");
/* 
    System.out.println();
    Patient sc = new Patient(1, "Thanh", 20, "Nam", "Ha Noi", "0987654321");
    System.out.println("Name:"+sc.getName());
    System.out.println("HIIHII");
    
    TestNumber.display();
    int rand = TestRandNumber.getTestRandNumber(1, 10);
    System.out.println("Random number: " + rand);
    TestRandNumber.in();
    Testpatient.display();

    Time now = new Time(14, 30, 45);
    now.display();
    now.setSecond(59);
    now.nextSecond();
    now.display();
  */
   TestPatient n = new TestPatient();
  n.play();
    }
}

