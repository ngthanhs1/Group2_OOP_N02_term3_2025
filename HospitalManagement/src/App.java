import HospitalManagement.test.TestRandNumber;

public class App {
    public static void main(String[] args) throws Exception {
    System.out.println("hi");
    System.out.println();
    Patient sc = new Patient(1, "Thanh", 20, "Nam", "Ha Noi", "0987654321");
    Patient sr = new Patient(1, "Quyen", 20, "Nam", "Ha Noi", "0358309009");
    System.out.println("Name:"+sc.getName());
    System.out.println("Name:"+sr.getName());
    }
}
