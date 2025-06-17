public class TestExceptionExample {
    static void g() throws Exception {
        throw new Exception("From g()"); 
    }

    static void f() throws Exception {
        g(); 
    }

    public static void main(String[] args) {
        try {
            f(); 
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
