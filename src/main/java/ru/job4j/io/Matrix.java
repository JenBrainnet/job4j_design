package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Matrix {

    public static void printMultipleTable(OutputStream output) throws IOException {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                output.write(String.format("%3d ", i * j).getBytes());
            }
            output.write(System.lineSeparator().getBytes());
        }
    }

    public static void main(String[] args) {
        try (FileOutputStream output = new FileOutputStream("data/multiple_table.txt")) {
            printMultipleTable(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
