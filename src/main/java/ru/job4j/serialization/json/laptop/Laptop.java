package ru.job4j.serialization.json.laptop;

import java.util.Arrays;

public class Laptop {

    private boolean isNew;
    private int ram;
    private String model;
    private Chip chip;
    private String[] ports;

    public Laptop(boolean isNew, int ram, String model, Chip chip, String[] ports) {
        this.isNew = isNew;
        this.ram = ram;
        this.model = model;
        this.chip = chip;
        this.ports = ports;
    }

    public boolean isNew() {
        return isNew;
    }

    public int getRam() {
        return ram;
    }

    public String getModel() {
        return model;
    }

    public Chip getChip() {
        return chip;
    }

    public String[] getPorts() {
        return ports;
    }

    @Override
    public String toString() {
        return "Laptop{"
                + "isNew=" + isNew
                + ", ram=" + ram
                + ", model='" + model + '\''
                + ", chip=" + chip
                + ", ports=" + Arrays.toString(ports)
                + '}';
    }

}
