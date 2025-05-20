package ru.job4j.iterator;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        list.listIterator(index).add(value);
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        list.listIterator(index + 1).add(value);
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        processMatching(list, filter, ListIterator::remove);
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        processMatching(list, filter, it -> it.set(value));
    }

    private static <T> void processMatching(List<T> list,
                                            Predicate<T> filter,
                                            Consumer<ListIterator<T>> action) {
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (filter.test(iterator.next())) {
                action.accept(iterator);
            }
        }
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        Set<T> elementsToRemove = new HashSet<>(elements);
        removeIf(list, elementsToRemove::contains);
    }

}
