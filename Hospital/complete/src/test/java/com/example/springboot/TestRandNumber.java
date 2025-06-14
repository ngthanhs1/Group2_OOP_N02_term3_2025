package HospitalManagement.Test;

import java.util.Random;

public class TestRandNumber {
    private static final Random random = new Random();

    /**
     * Trả về số nguyên ngẫu nhiên từ 0 đến max - 1
     * @param max giới hạn trên (không bao gồm)
     * @return số nguyên ngẫu nhiên
     */
    public static int getRandomIndex(int max) {
        if (max <= 0) return -1;
        return random.nextInt(max);
    }

    /**
     * Trả về true hoặc false ngẫu nhiên
     * @return giá trị boolean ngẫu nhiên
     */
    public static boolean getRandomBoolean() {
        return random.nextBoolean();
    }

    /**
     * Trả về số nguyên ngẫu nhiên từ min đến max (bao gồm cả 2)
     * @param min giới hạn dưới
     * @param max giới hạn trên
     * @return số nguyên ngẫu nhiên trong khoảng [min, max]
     */
    public static int getRandomInRange(int min, int max) {
        if (min > max) return -1;
        return random.nextInt((max - min) + 1) + min;
    }
}
