package ru.job4j.generics;

import java.util.*;

public class BoundedWildcardUsage {

    public void printInfo(Collection<? extends Person> collection) {
        for (Iterator<? extends Person> iterator = collection.iterator(); iterator.hasNext();) {
            Person next = iterator.next();
            System.out.println(next);
        }
    }

    public void addAll(List<? super Integer> list) {
        for (int i = 1; i <= 5; i++) {
            list.add(i);
        }
        for (Object line : list) {
            System.out.println("Текущий элемент: " + line);
        }
    }

    public static void main(String[] args) {
        List<Person> persons = List.of(new Person("name", 21, new Date(913716000000L)));
        new BoundedWildcardUsage().printInfo(persons);
        List<Programmer> programmers = List.of(new Programmer("name123", 23, new Date(913716000000L)));
        new BoundedWildcardUsage().printInfo(programmers);
        List<? super Integer> list = new ArrayList<>();
        new BoundedWildcardUsage().addAll(list);
    }

}
