package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        int number = 1;
        Scanner input = new Scanner(System.in);
        while (number < 100) {
            System.out.println(getFizzBuzzValue(number));
            number++;
            String answer = input.nextLine();
            String correctAnswer = getFizzBuzzValue(number);
            if (!correctAnswer.equals(answer)) {
                System.out.println("Ошибка. Начинай снова.");
                number = 1;
            } else {
                number++;
            }
        }
    }

    public static String getFizzBuzzValue(int startAt) {
        StringBuilder result = new StringBuilder();
        if (startAt % 3 == 0) {
            result.append("Fizz");
        }
        if (startAt % 5 == 0) {
            result.append("Buzz");
        }
        return result.isEmpty()
                ? String.valueOf(startAt)
                : result.toString();
    }

}
