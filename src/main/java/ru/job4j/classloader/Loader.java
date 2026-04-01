package ru.job4j.classloader;

public class Loader {

    public static void main(String[] args) {
        Class loader = Loader.class;
        System.out.println("Class of variable loader: " + loader);
        System.out.println("Class loader of variable loader: " + loader.getClassLoader());
        Class string = String.class;
        System.out.println("Class of variable string: " + string);
        System.out.println("Class loader of variable string: " + string.getClassLoader());
    }

}
