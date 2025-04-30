public class Student{
    private String name;
    private int id;
    private String address;
    private int age;

    public Student(int id,String name,int age,String address){
        this.id=id;
        this.name=name;
        this.age=age;
        this.address=address;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public int getAge(){
        return age;
    }
    public String getAddress(){
        return address;
    }
    public void display(){
        System.out.println("Id: "+getId());
        System.out.println("Name: "+getName());
        System.out.println("Age: "+getAge());
        System.out.println("Address: "+getAddress());
    }
    public void removeStudent(String id) {
        Student found = null;
        for (Student student : students) {
            if (student.getId().equals(id)) {
                found = student;
                break;
            }
        }
        if (found != null) {
            students.remove(found);
            System.out.println("Xóa sinh viên thành công!");
        } else {
            System.out.println("Không tìm thấy sinh viên với ID: " + id);
        }
    }
}

