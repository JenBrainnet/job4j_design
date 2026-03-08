package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class Search {

    public static void main(String[] args) throws IOException {
        validateArguments(args);
        Path start = Path.of(args[0]);
        search(start, path -> path.getFileName().toString().endsWith(args[1]))
                .forEach(System.out::println);
    }

    public static List<Path> search(Path root,
                                    Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void validateArguments(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Expected 2 arguments: directory and extension");
        }
        Path directory = Path.of(args[0]);
        if (!Files.exists(directory)) {
            throw new IllegalArgumentException(String.format("Directory does not exist: %s", args[0]));
        }
        if (!Files.isDirectory(directory)) {
            throw new IllegalArgumentException(String.format("Path is not a directory: %s", args[0]));
        }
        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException(String.format("Invalid extension: %s", args[1]));
        }
    }

}
