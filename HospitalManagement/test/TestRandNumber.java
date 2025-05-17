package HospitalManagement.test;

import java.util.Random;

public class TestRandNumber {
    

    public static int getTestRandNumber(int min,int max){
        Random rand = new Random();
        return rand.nextInt((max - min + 1)) + min;
    }
    public static void in(){
        System.out.println("buc");
    }
}
