package com.example.creator._04_builder._03_java;

import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        Stream.Builder<String> builder = Stream.builder();
        Stream<String> names = builder.add("keesun").add("whiteship").build();
        names.forEach(System.out::println);
    }
}
