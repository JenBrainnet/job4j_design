package ru.job4j.list;

import java.util.*;

public class ListUsage {

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        result.add("one");
        result.add("two");
        result.add("three");
        List<String> list = new ArrayList<>();
        list.add("four");
        list.add("five");
        result.addAll(2, list);
        result.add(5, "six");
        System.out.println("Добавление элементов в List: ");
        printList(result);

        result = new ArrayList<>(List.of("one", "two", "three"));
        System.out.println("Обход при помощи Iterator: ");
        Iterator<String> iterator = result.iterator();
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент: " + iterator.next());
        }
        System.out.println();

        System.out.println("Обход при помощи ListIterator с элемента с индексом 1: ");
        ListIterator<String> listIterator = list.listIterator(1);
        while (listIterator.hasNext()) {
            System.out.println("Текущий элемент: " + listIterator.next());
        }
        System.out.println();

        System.out.println("Обход в обратном порядке при помощи ListIterator: ");
        ListIterator<String> backwardIterator = list.listIterator(list.size());
        backwardIterator.add("six");
        while (backwardIterator.hasPrevious()) {
            System.out.println("Текущий элемент: " + backwardIterator.previous());
        }
        System.out.println();

        System.out.println("Изменение элемента: ");
        list.set(0, "three and four");
        printList(list);

        System.out.println("Использование replaceAll(UnaryOperator<E> operator): ");
        list.replaceAll(String::toUpperCase);
        printList(list);

        result = new ArrayList<>(List.of("one", "two", "three"));
        System.out.println("Удаление элемента с длиной больше 3: ");
        result.removeIf(string -> string.length() > 3);
        printList(result);

        boolean check = result.contains("two");
        System.out.println("Список содержит элемент: " + check);
        int index = result.indexOf("two");
        System.out.println("Индекс элемента в списке: " + index);
        result.add("one");
        int lastIndex = result.lastIndexOf("one");
        System.out.println("Индекс последнего вхождения: " + lastIndex);
        System.out.println("Размер списка равен: " + result.size());
        System.out.println();
        System.out.println("Sublist from 1 to 2 (excluded): ");
        list = result.subList(1, 2);
        printList(list);
        System.out.println("Сортировка в обратном порядке: ");
        result.sort(Comparator.reverseOrder());
        printList(result);
    }

    private static void printList(List<String> list) {
        for (String string : list) {
            System.out.println("Текущий элемент: " + string);
        }
        System.out.println();
    }

}
