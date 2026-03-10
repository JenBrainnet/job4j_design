package ru.job4j.regex;

import java.util.Arrays;

public class RegexSplitExample {

    public static void main(String[] args) {
        String string = "123+=-456:/789";
        String[] result = string.split("\\D+");
        System.out.println(Arrays.toString(result));
    }

}
