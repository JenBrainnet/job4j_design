package ru.job4j.serialization.xml.booking;

public class Room {

    private final String type;
    private final int number;

    public Room(String type, int number) {
        this.type = type;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Room{"
                + "type='" + type + '\''
                + ", number=" + number
                + '}';
    }

}
