package ru.job4j.pool;

public class IntPoolExample {

    public static void main(String[] args) {
        Integer pool1 = 127;
        Integer pool2 = 127;
        System.out.println(pool1 == pool2);
        Integer heap1 = -129;
        Integer heap2 = -129;
        System.out.println(heap1 == heap2);
        Integer heap3 = new Integer(127);
        Integer heap4 = new Integer(127);
        System.out.println(heap3 == heap4);
    }

}
