package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class CSVReader {

    public static void handle(ArgsName argsName) throws Exception {
        String path = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        String[] filters = argsName.get("filter").split(",");
        PrintStream output = "stdout".equals(out)
                ? System.out
                : new PrintStream(new FileOutputStream(out));

        try (Scanner scanner = new Scanner(Path.of(path))) {
            if (!scanner.hasNextLine()) {
                return;
            }
            List<Integer> indexes = new ArrayList<>();
            String[] headers = scanner.nextLine().split(delimiter);
            for (String filter : filters) {
                for (int i = 0; i < headers.length; i++) {
                    if (filter.equalsIgnoreCase(headers[i])) {
                        indexes.add(i);
                        break;
                    }
                }
            }
            output.println(join(headers, indexes, delimiter));
            while (scanner.hasNextLine()) {
                String[] line = scanner.nextLine().split(delimiter);
                output.println(join(line, indexes, delimiter));
            }
            if (!"stdout".equals(out)) {
                output.close();
            }
        }
    }

    private static String join(String[] line, List<Integer> indexes, String delimiter) {
        StringJoiner joiner = new StringJoiner(delimiter);
        for (Integer index : indexes) {
            joiner.add(line[index]);
        }
        return joiner.toString();
    }

    private static void validate(ArgsName argsName) {
        List<String> keys = List.of("path", "delimiter", "out", "filter");
        for (String key : keys) {
            argsName.get(key);
        }
        String file = argsName.get("path");
        if (!Files.exists(Path.of(file))) {
            throw new IllegalArgumentException(String.format("File: %s does not exist", file));
        }
        if (!file.endsWith(".csv")) {
            throw new IllegalArgumentException("Path must have .csv extension.");
        }
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        validate(argsName);
        handle(argsName);
    }

}
