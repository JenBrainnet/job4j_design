package ru.job4j.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UsageSet {

    public static void main(String[] args) {
        Set<String> immutableSet = Set.of("one", "two", "three");
        Set<String> strings = new HashSet<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("two");
        strings.addAll(List.of("one", "four", "five"));
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент: " + iterator.next());
        }
        strings.remove("two");
        strings.removeAll(List.of("four", "five"));
        System.out.println("Вывод в консоль после удаления...");
        System.out.println(strings);
        strings.retainAll(List.of("one"));
        System.out.println("Вывод после retainAll()...");
        System.out.println(strings);
        strings.addAll(List.of("two", "three", "four"));
        System.out.println(strings);
        strings.removeIf(s -> s.startsWith("t"));
        System.out.println("Вывод в консоль после removeIf()...");
        System.out.println(strings);
        boolean result = strings.contains("one");
        System.out.println("Множество содержит элемент: " + result);
        int size = strings.size();
        System.out.println("Множество содержит: " + size + " элемента.");
        strings.stream()
                .filter(s -> s.length() < 5)
                .forEach(s -> System.out.println("Текущий элемент: " + s));
    }

}
