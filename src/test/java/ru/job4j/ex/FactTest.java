package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactTest {

    @Test
    void calc() {
        Fact fact = new Fact();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    int rsl = fact.calc(-1);
    });
    assertThat(exception.getMessage()).isEqualTo(
            "Переменная n не может быть отрицательной.");
    }
}