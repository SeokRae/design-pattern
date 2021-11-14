package com.example.behavioural._13_chain_of_responsibilities._03_java;

import javax.servlet.*;
import java.io.IOException;

public class CoRInJava {

    public static void main(String[] args) {
        Filter filter = (request, response, chain) -> {
            // TODO 전처리
            chain.doFilter(request, response);
            // TODO 후처리
        };
    }
}
