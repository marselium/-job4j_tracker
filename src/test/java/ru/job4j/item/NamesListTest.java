package ru.job4j.item;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NamesListTest {
    @Test
    public void whenSortAscByName() {
        NamesList first = new NamesList("ab");
        NamesList second = new NamesList("bc");
        NamesList third = new NamesList("cd");
        NamesList fourth = new NamesList("df");
        List<NamesList> namesLists = Arrays.asList(second, fourth, first, third);
        namesLists.sort(new ItemAscByName());
        List<NamesList> expected = Arrays.asList(first, second, third, fourth);
        assertThat(namesLists).isEqualTo(expected);
    }

    @Test
    public void whenDescByName() {
        NamesList first = new NamesList("ab");
        NamesList second = new NamesList("bc");
        NamesList third = new NamesList("cd");
        NamesList fourth = new NamesList("df");
        List<NamesList> namesLists = Arrays.asList(second, fourth, first, third);
        namesLists.sort(new ItemDescByName());
        List<NamesList> expected = Arrays.asList(fourth, third, second, first);
        assertThat(namesLists).isEqualTo(expected);
    }
}