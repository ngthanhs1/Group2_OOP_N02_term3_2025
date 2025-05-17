import HospitalManagement.test.TestNumber;
import HospitalManagement.test.TestRandNumber;
import HospitalManagement.test.Testpatient;

public class App {
    public static void main(String[] args) throws Exception {
  System.out.println("hi");


    System.out.println();
    Patient sc = new Patient(1, "Thanh", 20, "Nam", "Ha Noi", "0987654321");
    System.out.println("Name:"+sc.getName());
    System.out.println("HIIHII");
    
    TestNumber.display();
    int rand = TestRandNumber.getTestRandNumber(1, 10);
        System.out.println("Random number: " + rand);
    TestRandNumber.in();
    Testpatient.display();
    }
}

