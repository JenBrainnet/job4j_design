package ru.job4j.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Job4j", Pattern.CASE_INSENSITIVE);

        String textOne = "Job4j and Job4j and Job4j";
        Matcher matcherOne = pattern.matcher(textOne);
        while (matcherOne.find()) {
            System.out.println(
                    "Найдено совпадение: " + matcherOne.group()
                    + ". iStart: " + matcherOne.start()
                    + " iEnd: " + matcherOne.end()
            );
        }
        String textTwo = "job4j";
        Matcher matcherTwo = pattern.matcher(textTwo);
        boolean isPresentTwo = matcherTwo.matches();
        System.out.println(isPresentTwo);

        Pattern patternNums = Pattern.compile("123");
        String text = "1231 and 1232 and 1233";
        Matcher matcher = patternNums.matcher(text);
        String result = matcher.replaceAll("Job4j");
        System.out.println(result);
    }

}
