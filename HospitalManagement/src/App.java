import HospitalManagement.test.TestRandNumber;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("hi");
        
        System.out.println();
        Patient sc = new Patient(1, "Thanh", 20, "Nam", "Ha Noi", "0987654321");
        System.out.println(sc.id +" "+sc.name+" "+sc.age);
        System.out.println("Phone: "+sc.getPhoneNumber());
    }
}
