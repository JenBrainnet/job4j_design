package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenNumbersIterator implements Iterator<Integer> {

    private final int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
        this.index = -1;
    }

    @Override
    public boolean hasNext() {
        moveToNextEvenNumber();
        return index < data.length;
    }

    @Override
    public Integer next() {
        moveToNextEvenNumber();
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }

    private void moveToNextEvenNumber() {
        while (index < 0 || index != data.length && data[index] % 2 != 0) {
            index++;
        }
    }

}
