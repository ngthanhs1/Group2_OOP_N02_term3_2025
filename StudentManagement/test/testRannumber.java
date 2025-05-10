package StudentManagement.test;

import java.util.Random;


public class testRannumber {
    private Random rand;
    public testRannumber(){
        rand = new Random();
    }
     public int gettestRannumber(int min, int max) {
        return rand.nextInt(max-min+1)+min;
     }
}
