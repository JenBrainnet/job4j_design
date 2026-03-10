package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {

    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> answers = readPhrases();
        List<String> log = new ArrayList<>();
        Random random = new Random();
        boolean chatActive = true;
        boolean botActive = true;
        Scanner scanner = new Scanner(System.in);
        while (chatActive) {
            System.out.print("User: ");
            String message = scanner.nextLine();
            log.add("User: " + message);
            switch (message) {
                case CONTINUE -> botActive = true;
                case STOP -> botActive = false;
                case OUT -> chatActive = false;
                default -> {
                    if (botActive) {
                        String phrase = "Bot: " + answers.get(random.nextInt(answers.size()));
                        System.out.println(phrase);
                        log.add(phrase);
                    }
                }
            }
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> phrases = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(botAnswers, Charset.forName("WINDOWS-1251")))) {
            reader.lines().forEach(phrases::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return phrases;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(path, Charset.forName("WINDOWS-1251")))) {
            log.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat consoleChat = new ConsoleChat("./data/bot_log.txt", "./data/bot_answers.txt");
        consoleChat.run();
    }

}
