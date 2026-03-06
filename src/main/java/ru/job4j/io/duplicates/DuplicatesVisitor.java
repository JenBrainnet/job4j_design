package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Map<FileProperty, List<Path>> files = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.getFileName().toString());
        files.computeIfAbsent(fileProperty, v -> new ArrayList<>()).add(file);
        return super.visitFile(file, attrs);
    }

    public void printDuplicates() {
        for (Map.Entry<FileProperty, List<Path>> entry : files.entrySet()) {
            if (entry.getValue().size() > 1) {
                FileProperty fileProperty = entry.getKey();
                System.out.printf(
                        "%s - %.1f Mb\n",
                        fileProperty.getName(),
                        bytesToMb(fileProperty.getSize())
                );
                for (Path path : entry.getValue()) {
                    System.out.printf("  %s\n", path.toAbsolutePath());
                }
            }
        }
    }

    private double bytesToMb(long bytes) {
        return bytes / (1024.0 * 1024);
    }

}
