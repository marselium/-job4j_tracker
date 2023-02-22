package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

public class JobTest {

    @Test
    public void whenAscByName() {
        Comparator<Job> cmpName = new JobAscByName();
        int rsl = cmpName.compare(
                new Job("Write a program", 0),
                new Job("Fix bugs", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenAscByPriority() {
        Comparator<Job> cmpName = new JobAscByPriority();
        int rsl = cmpName.compare(
                new Job("Reboot server", 0),
                new Job("Fix bugs", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenDescByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Fix bugs", 0),
                new Job("Fix bugs", 1)
        );
        assertThat(rsl).isEqualTo(0);
    }

    @Test
    public void whenDescByPriority() {
        Comparator<Job> cmpName = new JobDescByPriority();
        int rsl = cmpName.compare(
                new Job("Fix bugs", 0),
                new Job("Fix bugs", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Reboot server", 0),
                new Job("Fix bugs", 1)
        );
        assertThat(rsl).isLessThan(0);
    }

    @Test
    public void whenAscByNameAndPriority() {
        Comparator<Job> cmpNamePriorityAsc = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriorityAsc.compare(
                new Job("Reboot server", 0),
                new Job("Fix bugs", 1)
        );
        assertThat(rsl).isGreaterThan(0);
    }
}