import StudentManagement.test.TestRandNumber;

public class App {
    public static void main(String[] args) throws Exception {
        
        System.out.println();
        TestRandNumber sr = new TestRandNumber();
        int number = sr.getTestRandNumber(50, 100);
        System.out.println("So ngau nhien: "+number);
    }
}
