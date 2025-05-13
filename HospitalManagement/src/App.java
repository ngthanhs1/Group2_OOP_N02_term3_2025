import HospitalManagement.test.TestRandNumber;

public class App {
    public static void main(String[] args) throws Exception {
// Từ Current Change
Patient patient = new Patient(id:1, name:"Quyen", age:17, gender:"Nam", address:"Ha Nam", phoneNumber:"0358309009");
patient.printInfo();

// Từ Incoming Change
System.out.println("hi");
System.out.println();
Patient sc = new Patient(1, "Thanh", 20, "Nam", "Ha Noi", "0987654321");
System.out.println(sc.id + " " + sc.name + " " + sc.age);
System.out.println("Phone: " + sc.getPhoneNumber());

    }
}
