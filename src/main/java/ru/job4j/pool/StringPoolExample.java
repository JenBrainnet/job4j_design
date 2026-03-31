package ru.job4j.pool;

public class StringPoolExample {

    public static void main(String[] args) {
        char[] chars = {'H', 'e', 'l', 'l', 'o'};
        String stringFromChars = new String(chars);

        String string1 = "Hello";
        String string2 = "Hello";
        String string3 = new String("Hello");
        String string4 = new String("Hello");
        System.out.println(string1 == string2);
        System.out.println(string3 == string4);
        System.out.println(string1 == string3);
        String string5 = string3.intern();
        System.out.println(string1 == string5);

        String str1 = "Hello, world";
        String str2 = "Hello, " + "world";
        System.out.println(str1 == str2);
        String str3 = "Hello, ";
        String str4 = str3 + "world";
        System.out.println(str1 == str4);

        System.out.println(new String("New string") == new String("New string"));
        System.out.println(new String("New string").intern() == new String("New string").intern());

    }

}
