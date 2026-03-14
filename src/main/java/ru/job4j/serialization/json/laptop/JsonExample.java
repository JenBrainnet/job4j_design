package ru.job4j.serialization.json.laptop;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class JsonExample {

    public static void main(String[] args) {
        Laptop macBook = new Laptop(
                true,
                48,
                "MacBook Pro 14",
                new Chip("M5 Pro", 16),
                new String[] {"Thunderbolt", "HDMI", "MagSafe"}
        );

        JSONObject jsonChip = new JSONObject();
        jsonChip.put("name", macBook.getChip().getName());
        jsonChip.put("cores", macBook.getChip().getCores());
        JSONArray jsonPorts = new JSONArray(List.of(macBook.getPorts()));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("isNew", macBook.isNew());
        jsonObject.put("ram", macBook.getRam());
        jsonObject.put("model", macBook.getModel());
        jsonObject.put("chip", jsonChip);
        jsonObject.put("ports", jsonPorts);

        System.out.println(new JSONObject(macBook));
        System.out.println(jsonObject);
    }

}
