package com.example.behavioural._20_state._02_after;

import java.util.HashSet;
import java.util.Set;

public class Student {

    private final String name;

    public Student(String name) {
        this.name = name;
    }

    private final Set<OnlineCourse> onlineCourses = new HashSet<>();

    public boolean isAvailable(OnlineCourse onlineCourse) {
        return onlineCourses.contains(onlineCourse);
    }

    public void addPrivate(OnlineCourse onlineCourse) {
        this.onlineCourses.add(onlineCourse);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
