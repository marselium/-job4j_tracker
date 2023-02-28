package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.lang.Math.*;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(1, 3, x -> 2 * Math.pow(x, x) + 3 * x + 1);
        List<Double> expected = Arrays.asList(6D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenExpFunctionThenExpResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(2, 4, x -> 2 * Math.pow(3D, x));
        List<Double> expected = Arrays.asList(18D, 54D);
        assertThat(result).containsAll(expected);
    }
}