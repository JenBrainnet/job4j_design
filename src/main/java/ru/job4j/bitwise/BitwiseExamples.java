package ru.job4j.bitwise;

public class BitwiseExamples {

    public static int findNumberOfBits(int x, int y) {
        int bitCount = 0;
        int z = x ^ y;
        while (z != 0) {
            bitCount += z & 1;
            z >>= 1;
        }
        return bitCount;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-5));
        System.out.println(Integer.toBinaryString(5 << 1));
        System.out.println(-5 << 1);
        System.out.println(10 >> 1);
        System.out.println(2_147_483_647 << 1);
        System.out.println(24 >>> 1);
        System.out.println(-24 >>> 1);
        byte n = 27;
        n = (byte) (n << 1);
        System.out.println(n);
        System.out.println(-1 >> 32);
        System.out.println(-1 >>> 32);
        System.out.println(1 >> 32);
        System.out.println(findNumberOfBits(12, 16));
    }

}
