package ru.job4j.bitwise;

public class BinaryFormatter {

    public static String binary(int number) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            buffer.append(number % 2 == 0 ? 0 : 1);
            buffer.append((i + 1) % 8 == 0 ? " " : "");
            number /= 2;
        }
        return buffer.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(binary(255));
        System.out.println(binary(255 >>> 4));
        System.out.println();
        System.out.println(binary(Integer.MAX_VALUE));
        System.out.println(binary(Integer.MAX_VALUE >>> 16));
        System.out.println();
        int h = 123456789;
        System.out.println(binary(h));
        System.out.println(binary(h >>> 16));
        System.out.println(binary(h ^ (h >>> 16)));
        System.out.println((h ^ (h >>> 16)) & 15);
        System.out.println();
        System.out.println("(16 - 1) = " + binary(16 - 1));
        System.out.println("(32 - 1) = " + binary(32 - 1));
        System.out.println("(64 - 1) = " + binary(64 - 1));
    }

}
