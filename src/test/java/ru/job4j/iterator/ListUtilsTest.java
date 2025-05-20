package ru.job4j.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ListUtilsTest {

    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddAfterLastElement() {
        ListUtils.addAfter(input, 1, 99);
        assertThat(input).hasSize(3).containsSequence(1, 3, 99);
    }

    @Test
    void whenAddAfterWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 10, 99))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenRemoveIf() {
        input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListUtils.removeIf(input, x -> x % 2 == 0);
        assertThat(input).hasSize(3).containsExactly(1, 3, 5);
    }

    @Test
    void whenRemoveIfWithNoMatches() {
        ListUtils.removeIf(input, x -> x > 100);
        assertThat(input).containsExactly(1, 3);
    }

    @Test
    void whenReplaceIf() {
        input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        ListUtils.replaceIf(input, x -> x < 4, 0);
        assertThat(input).containsExactly(0, 0, 0, 4, 5, 6);
    }

    @Test
    void whenReplaceIfReplacesAll() {
        ListUtils.replaceIf(input, x -> true, 0);
        assertThat(input).containsExactly(0, 0);
    }

    @Test
    void whenReplaceIfWithNoMatches() {
        ListUtils.replaceIf(input, x -> x > 100, 0);
        assertThat(input).containsExactly(1, 3);
    }

    @Test
    void whenRemoveAll() {
        ListUtils.removeAll(input, List.of(1, 2));
        assertThat(input).hasSize(1).containsExactly(3);
    }

    @Test
    void whenRemoveAllWithDuplicates() {
        input = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 4, 5, 6, 5));
        ListUtils.removeAll(input, List.of(1, 3, 5, 7, 8));
        assertThat(input).hasSize(3).containsExactly(2, 4, 6);
    }

    @Test
    void whenRemoveAllRemovesAll() {
        ListUtils.removeAll(input, List.of(1, 3));
        assertThat(input).isEmpty();
    }

    @Test
    void whenRemoveAllWithNoMatches() {
        ListUtils.removeAll(input, List.of(100, 200));
        assertThat(input).containsExactly(1, 3);
    }

}