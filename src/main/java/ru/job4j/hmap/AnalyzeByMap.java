package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double rsl = 0;
        int score = 0;
        for (Pupil pupil : pupils) {
            for (Subject subj : pupil.subjects()) {
                rsl += subj.score();
                score++;
            }
        }
        return rsl / score;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> pupilsList = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            pupilsList.add(new Label(pupil.name(), sum / pupil.subjects().size()));
        }
        return pupilsList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> subjectList = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
            }

        }
        for (String key : map.keySet()) {
            subjectList.add(new Label(key, (map.get(key) / pupils.size())));
        }
        return subjectList;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> studentList = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(pupil.name(), map.getOrDefault(pupil.name(), 0) + subject.score());
            }
        }
        for (String key : map.keySet()) {
            studentList.add(new Label(key, map.get(key)));
        }
        studentList.sort(Comparator.naturalOrder());
        return studentList.get(studentList.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> subjectList = new ArrayList<>();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.put(subject.name(), map.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String key : map.keySet()) {
            subjectList.add(new Label(key, map.get(key)));
        }
        subjectList.sort(Comparator.naturalOrder());
        return subjectList.get(subjectList.size() - 1);
    }
}