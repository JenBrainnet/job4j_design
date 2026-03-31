package ru.job4j.gc.cache;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        Path path = Path.of(cachingDir);
        if (!Files.exists(path)) {
            throw new IllegalArgumentException(String.format("Directory does not exist: %s", path));
        }
        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException(String.format("Path is not a directory: %s", path));
        }
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        Path file = Path.of(cachingDir, key);
        try {
            return Files.readString(file);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file", e);
        }
    }

}
