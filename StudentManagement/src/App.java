import StudentManagement.test.testRannumber;

public class App {
    public static void main(String[] args) throws Exception{
        testRannumber sr = new testRannumber();
        int Number = sr.gettestRannumber(1,1000);
        System.out.println("So ngau nhien: "+Number);
    }
}
