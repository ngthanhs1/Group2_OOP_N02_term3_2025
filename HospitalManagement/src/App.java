import HospitalManagement.test.TestNumber;
import HospitalManagement.test.TestRandNumber;


public class App {
    public static void main(String[] args) throws Exception {
  System.out.println("hi");


    System.out.println();
    Patient sc = new Patient(1, "Thanh", 20, "Nam", "Ha Noi", "0987654321");
    System.out.println("Name:"+sc.getName());
    System.out.println("HIIHII");
    
    TestNumber.display();
    TestRandNumber.getTestRandNumber(1, 2);
    TestRandNumber.in();
    }
}

