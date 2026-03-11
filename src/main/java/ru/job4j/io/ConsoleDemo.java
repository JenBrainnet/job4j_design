package ru.job4j.io;

import java.io.Console;
import java.util.Arrays;

public class ConsoleDemo {

    public static void main(String[] args) {
        String login;
        char[] charPassword;
        Console console = System.console();
        if (console == null) {
            System.out.println("Console is unavailable");
            return;
        }
        login = console.readLine("%s", "Enter login: ");
        console.printf("Your login: %s\n", login);
        charPassword = console.readPassword("%s", "Enter password: ");
        System.out.println("Your password: " + String.valueOf(charPassword));
        Arrays.fill(charPassword, ' ');
    }

}
