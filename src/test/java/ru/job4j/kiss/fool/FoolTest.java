package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class FoolTest {

    @Test
    void whenNumberDivisibleBy3ThenReturnFizz() {
        assertThat(Fool.getFizzBuzzValue(3)).isEqualTo("Fizz");
    }

    @Test
    void whenNumberDivisibleBy5ThenReturnBuzz() {
        assertThat(Fool.getFizzBuzzValue(5)).isEqualTo("Buzz");
    }

    @Test
    void whenNumberDivisibleBy3AndBy5ThenReturnFizzBuzz() {
        assertThat(Fool.getFizzBuzzValue(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void whenNumberNotDivisibleBy3AndBy5ThenReturnNumber() {
        assertThat(Fool.getFizzBuzzValue(2)).isEqualTo("2");
    }

}