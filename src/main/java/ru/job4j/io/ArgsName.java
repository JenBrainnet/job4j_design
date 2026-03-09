package ru.job4j.io;

import java.util.*;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        String value = values.get(key);
        if (value == null) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", key));
        }
        return value;
    }

    private void parse(String[] args) {
        for (String arg : args) {
            validate(arg);
            String[] pair = arg.split("=", 2);
            values.put(pair[0].replaceFirst("-", ""), pair[1]);
        }
    }

    private void validate(String arg) {
        if (!arg.startsWith("-")) {
            throw new IllegalArgumentException(
                    String.format("Error: This argument '%s' does not start with a '-' character", arg)
            );
        }
        String[] pair = arg.split("=", 2);
        if (pair.length != 2) {
            throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain an equal sign", arg));
        }
        if (pair[0].length() < 2) {
            throw new IllegalArgumentException(
                    String.format("Error: This argument '%s' does not contain a key", arg)
            );
        }
        if (pair[1].isEmpty()) {
            throw new IllegalArgumentException(
                    String.format("Error: This argument '%s' does not contain a value", arg)
            );
        }
    }

    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }

}
