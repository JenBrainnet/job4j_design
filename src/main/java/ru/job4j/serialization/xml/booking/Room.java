package ru.job4j.serialization.xml.booking;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "room")
public class Room {

    @XmlAttribute
    private String type;

    @XmlAttribute
    private int number;

    public Room() {
    }

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
