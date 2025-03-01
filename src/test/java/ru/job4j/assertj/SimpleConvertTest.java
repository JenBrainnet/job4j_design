package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list)
                .isNotNull()
                .isInstanceOf(List.class)
                .contains("five", Index.atIndex(4))
                .containsSequence("four", "five")
                .filteredOn(s -> s.length() > 4)
                .doesNotContainSequence("four", "five")
                .hasSize(3)
                .last()
                .isEqualTo("three");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five", "five");
        assertThat(set)
                .isInstanceOf(Set.class)
                .hasSize(5)
                .containsAnyOf("value", "first")
                .allSatisfy(s -> {
                    assertThat(s).isAlphabetic();
                    assertThat(s).isLowerCase();
                })
                .filteredOn(s -> s.startsWith("f"))
                .hasSize(3)
                .allMatch(s -> s.length() < 6);
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five", "five");
        assertThat(map)
                .isInstanceOf(Map.class)
                .hasSize(5)
                .containsKey("five")
                .containsValues(0, 1, 2, 3, 4)
                .containsEntry("first", 0)
                .containsExactlyInAnyOrderEntriesOf(Map.of(
                        "first", 0,
                        "second", 1,
                        "three", 2,
                        "four", 3,
                        "five", 4
                ));
    }

}