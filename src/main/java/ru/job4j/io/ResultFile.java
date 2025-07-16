package ru.job4j.io;

import java.io.*;

public class ResultFile {

    public static void main(String[] args) {
        try (PrintWriter output = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream("data/dataresult.txt")
                ))) {
            output.println("Hello, World!");
            output.printf("%s%s", "Some string", System.lineSeparator());
            output.printf("%d%n", 10);
            output.printf("%.1f%n", 1.5f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
