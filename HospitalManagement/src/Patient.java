public class Patient {
     int id;
     String name;
     int age;
     String gender;
     String address;
     String phoneNumber;
     String address;
     String phoneNumber;
    
    public Patient(int id, String name, int age, String gender, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public void printInfo() {
        System.out.println("Thông tin bệnh nhân:");
        System.out.println("Mã bệnh nhân: " + id);
        System.out.println("Họ tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Giới tính: " + gender);
        System.out.println("Địa chỉ: " + address);
        System.out.println("Số điện thoại: " + phoneNumber);
    }
}
