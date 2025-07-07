package ru.job4j.io;

import java.io.FileInputStream;
import java.io.IOException;

public class EvenNumberFile {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try (FileInputStream input = new FileInputStream("data/even.txt")) {
            int read;
            while ((read = input.read()) != -1) {
                sb.append((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] lines = sb.toString().split(System.lineSeparator());
        for (String line : lines) {
            int number = Integer.parseInt(line);
            System.out.print(number);
            System.out.println((number % 2 == 0 ? " - even" : " - odd"));
        }
    }

}
