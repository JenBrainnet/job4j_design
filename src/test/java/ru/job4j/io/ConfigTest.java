package ru.job4j.io;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }

    @Test
    void whenPairWithEqualsInValue() {
        String path = "./data/pair_with_equals_in_value.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key1")).isEqualTo("value1=");
        assertThat(config.value("key2")).isEqualTo("=value2");
        assertThat(config.value("key3")).isEqualTo("value=3");
    }

    @Test
    void whenPairWithCommentsAndEmptyStrings() {
        String path = "./data/pair_with_comment_and_empty_strings.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key1")).isEqualTo("value1");
        assertThat(config.value("")).isNull();
        assertThat(config.value("# Comment")).isNull();
    }

    @Test
    void whenPairWithInvalidFormat() {
        String path = "./data/pair_with_invalid_format.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid format: expected \"key=value\" pattern");
    }

    @Test
    void whenPairWithMissingKey() {
        String path = "./data/pair_with_missing_key.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid format: expected \"key=value\" pattern");
    }

    @Test
    void whenPairWithMissingValue() {
        String path = "./data/pair_with_missing_value.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Invalid format: expected \"key=value\" pattern");
    }

}