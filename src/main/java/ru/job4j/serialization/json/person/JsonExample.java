package ru.job4j.serialization.json.person;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

public class JsonExample {

    public static void main(String[] args) {
        final Person person = new Person(
                false,
                30,
                new Contact("11-111"),
                new String[]{"Worker", "Married"}
        );

        JSONObject jsonContact = new JSONObject("{\"phone\":\"" + person.getContact().getPhone() + "\"}");
        JSONArray jsonStatuses = new JSONArray(List.of(person.getStatuses()));

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.isSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        System.out.println(jsonObject);
        System.out.println(new JSONObject(person));
    }

}
