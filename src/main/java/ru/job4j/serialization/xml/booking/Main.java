package ru.job4j.serialization.xml.booking;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.StringReader;
import java.io.StringWriter;

public class Main {

    public static void main(String[] args) throws Exception {
        Booking booking = new Booking(
                true,
                6,
                "Hilton",
                "Petr Arsentev",
                new Room("Deluxe", 305),
                new String[] {"SPA", "Breakfast", "Wi-Fi"}
        );
        JAXBContext context = JAXBContext.newInstance(Booking.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(booking, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Booking result = (Booking) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }

}
