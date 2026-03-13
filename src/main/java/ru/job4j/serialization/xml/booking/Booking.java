package ru.job4j.serialization.xml.booking;

import java.util.Arrays;

public class Booking {

    private final boolean confirmed;
    private final int nights;
    private final String hotelName;
    private final String guestName;
    private final Room room;
    private final String[] services;

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
