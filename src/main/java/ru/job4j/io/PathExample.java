package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

    public static void main(String[] args) throws IOException {
        Path directory = Paths.get("path/paths");
        if (!Files.exists(directory)) {
            Files.createDirectories(directory);
        }
        Path path = Path.of("path/paths/path.txt");
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        File file = path.toFile();
        System.out.println(file);
        Path pathAgain = file.toPath();
        System.out.println(pathAgain);
        System.out.println("Файл/директория существует?: " + Files.exists(path));
        System.out.println("Это директория?: " + Files.isDirectory(path));
        System.out.println("Это файл?: " + Files.isRegularFile(path));
        System.out.println("Имя файла: " + pathAgain.getFileName());
        System.out.println("Путь к файлу абсолютный?: " + path.isAbsolute());
        System.out.println("Родительская директория файла: " + path.getParent());
        System.out.println("Абсолютный путь к файлу: " + path.toAbsolutePath());
        System.out.println("Абсолютный путь к директории: " + directory.toAbsolutePath());
        System.out.println("Доступен для чтения?: " + Files.isReadable(path));
        System.out.println("Доступен для записи?: " + Files.isWritable(path));
        Path newPath = Path.of("path/path.txt");
        System.out.println("Перемещение path/paths/path.txt -> path/path.txt");
        Files.move(path, newPath);
        System.out.println("path/paths/path.txt существует?: " + Files.exists(path));
        System.out.println("path/path.txt существует?: " + Files.exists(newPath));
        Files.delete(newPath);
        Files.deleteIfExists(directory);
        Files.delete(directory.getParent());
    }

}
