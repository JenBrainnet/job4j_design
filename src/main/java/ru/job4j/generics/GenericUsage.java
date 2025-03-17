package ru.job4j.generics;

import java.util.*;

public class GenericUsage {

    public void printResult(Collection<?> collection) {
        for (Iterator<?> iterator = collection.iterator(); iterator.hasNext();) {
            Object next = iterator.next();
            System.out.println("Текущий элемент: " + next);
        }
    }

    public static void main(String[] args) {
        List list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add(new Person("name", 21, new Date(913716000000L)));
        System.out.println("Количество элементов в списке: " + list.size());
        List<Integer> integers = List.of(1, 2, 3, 4, 5);
        new GenericUsage().printResult(integers);
    }

}
