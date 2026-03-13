package ru.job4j.serialization.json.laptop;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonExample {

    public static void main(String[] args) {
        final Laptop laptop = new Laptop(
                false,
                16,
                "Dell XPS 13",
                new Chip("Intel Core i7", 10),
                new String[] {"USB-C", "USB-A", "HDMI"}
        );
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(laptop));
        final String laptopJson =
                "{"
                        + "\"isNew\":true,"
                        + "\"ram\":48,"
                        + "\"model\":\"MacBook Pro\","
                        + "\"chip\":"
                        + "{"
                        + "\"name\":\"M5 Pro 16\","
                        + "\"cores\":16"
                        + "},"
                        + "\"ports\":"
                        + "[\"Thunderbolt\",\"HDMI\",\"MagSafe\"]"
                        + "}";
        final Laptop laptopMod = gson.fromJson(laptopJson, Laptop.class);
        System.out.println(laptopMod);
    }

}
