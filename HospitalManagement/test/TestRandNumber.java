package HospitalManagement.test;

import java.util.Random;

public class TestRandNumber {
    private Random random;

    public TestRandNumber() {
        random = new Random();
    };

    public  int getTestRandNumber(int min,int max){
        return random.nextInt(max-min+1) + min;
    }
}
