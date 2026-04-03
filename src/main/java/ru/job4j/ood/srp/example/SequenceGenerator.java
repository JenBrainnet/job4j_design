package ru.job4j.ood.srp.example;

import java.util.List;

public interface SequenceGenerator<T> {

    List<T> generate(int size);

}
