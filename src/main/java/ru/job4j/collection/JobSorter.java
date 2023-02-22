package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bugs", 5),
                new Job("Impl task", 4),
                new Job("Reboot server", 3),
                new Job("Reboot server", 2),
                new Job("Reboot server", 1)
        );
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobDescByPriority()));
        System.out.println(jobs);
    }
}