package ru.job4j.serialization.json.laptop;

public class Chip {

    private String name;
    private int cores;

    public Chip(String name, int cores) {
        this.name = name;
        this.cores = cores;
    }

    public String getName() {
        return name;
    }

    public int getCores() {
        return cores;
    }

    @Override
    public String toString() {
        return "Chip{"
                + "name='" + name + '\''
                + ", cores=" + cores
                + '}';
    }

}
