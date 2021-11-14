package com.example.behavioural._14_command._02_after;

import com.example.behavioural._14_command._01_before.Game;

public class MyApp {

    private final Command command;

    public MyApp(Command command) {
        this.command = command;
    }

    public void press() {
        command.execute();
    }

    public static void main(String[] args) {
        MyApp myApp = new MyApp(new GameStartCommand(new Game()));
    }
}
