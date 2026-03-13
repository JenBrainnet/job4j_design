package ru.job4j.serialization.xml.booking;

import jakarta.xml.bind.annotation.*;

import java.util.Arrays;

@XmlRootElement(name = "booking")
@XmlAccessorType(XmlAccessType.FIELD)
public class Booking {

    @XmlAttribute
    private boolean confirmed;

    @XmlAttribute
    private int nights;

    @XmlAttribute
    private String hotelName;

    @XmlAttribute
    private String guestName;
    private Room room;

    @XmlElementWrapper(name = "services")
    @XmlElement(name = "service")
    private String[] services;

    public Booking() {
    }

    public Booking(boolean confirmed, int nights, String hotelName, String guestName, Room room, String[] services) {
        this.confirmed = confirmed;
        this.nights = nights;
        this.hotelName = hotelName;
        this.guestName = guestName;
        this.room = room;
        this.services = services;
    }

    @Override
    public String toString() {
        return "Booking{"
                + "confirmed=" + confirmed
                + ", nights=" + nights
                + ", hotelName='" + hotelName + '\''
                + ", guestName='" + guestName + '\''
                + ", room=" + room
                + ", services=" + Arrays.toString(services)
                + '}';
    }

}
