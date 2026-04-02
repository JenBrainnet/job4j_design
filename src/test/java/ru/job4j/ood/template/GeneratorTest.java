package ru.job4j.ood.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@Disabled("Tests are disabled. Remove the annotation after implementing all methods required bu the task.")
class GeneratorTest {

    @Test
    void whenAllPlaceholdersAreReplacedThenProduceExpectedString() {
        Generator generator = new TemplateGenerator();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of(
                "name", "Petr Arsentev",
                "subject", "you"
        );
        String expected = "I am Petr Arsentev, Who are you?";
        String result = generator.produce(template, args);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void whenMapNotContainsKeyFromTemplateThenExceptionIsThrown() {
        Generator generator = new TemplateGenerator();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of(
                "name", "Petr Arsentev"
        );
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void whenMapContainsExtraKeyThenExceptionIsThrown() {
        Generator generator = new TemplateGenerator();
        String template = "I am ${name}, Who are ${subject}?";
        Map<String, String> args = Map.of(
                "name", "Petr Arsentev",
                "subject", "you",
                "age", "35"
        );
        assertThatThrownBy(() -> generator.produce(template, args))
                .isInstanceOf(IllegalArgumentException.class);
    }

}