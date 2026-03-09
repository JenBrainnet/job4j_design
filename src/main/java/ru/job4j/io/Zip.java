package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
                try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                    zip.write(output.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream output = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(output.readAllBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void validate(String directory, String exclude, String output) {
        Path dir = Path.of(directory);
        if (!Files.exists(dir)) {
            throw new IllegalArgumentException(String.format("Directory does not exist: %s", directory));
        }
        if (!Files.isDirectory(dir)) {
            throw new IllegalArgumentException(String.format("Path is not a directory: %s", directory));
        }
        if (!exclude.startsWith(".")) {
            throw new IllegalArgumentException(String.format("Invalid extension: %s", exclude));
        }
        if (!output.endsWith(".zip")) {
            throw new IllegalArgumentException(String.format("Output file must have .zip extension: %s", output));
        }
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        ArgsName argsName = ArgsName.of(args);
        String directory = argsName.get("d");
        String exclude = argsName.get("e");
        String output = argsName.get("o");
        zip.validate(directory, exclude, output);
        List<Path> files = Search.search(
                Path.of(directory),
                p -> !p.getFileName().toString().endsWith(exclude)
        );
        zip.packFiles(files, new File(output));
    }

}
