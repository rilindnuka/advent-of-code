package com.adventofcode.days;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.adventofcode.config.Utils.readInput;

public class Day03 {
    public static final Logger logger = LoggerFactory.getLogger(Day03.class);

    public static void main(String[] args) throws IOException {
        logger.info("This is the puzzle from day 3");
        String input = readInput("day03/input.txt");
        logger.info("\nPart 1: \n{}", part1(input));
        logger.info("\nPart 2: \n{}", part2(input.replace("\n","")));
    }

    public static long part1(String input) {
        int sum = 0;
        Pattern pattern = Pattern.compile("mul[(]\\d{1,3},\\d{1,3}[)]");
        Matcher matcher = pattern.matcher(input);
        ArrayList<String> matches = new ArrayList<>();
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        for (int i = 0; i < matches.size(); i++) {
            String command = matches.get(i);

            String numbersString = command.substring(4, command.length() - 1);
            String[] numbers = numbersString.split(",");
            Integer firstNumber = Integer.valueOf(numbers[0]);
            Integer secondNumber = Integer.valueOf(numbers[1]);
            sum += firstNumber * secondNumber;
        }
        return sum;
    }


    public static long part2(String input) {
        long sum = 0;
        boolean continueAdding = true;
        String doContinue="do()";
        String dontContinue="don't()";
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            //Searching for do()
            if (i >=4){
                char a = input.charAt(i-3);
                char b = input.charAt(i-2);
                char c = input.charAt(i-1);
                char d = input.charAt(i);
                String shortText = String.copyValueOf(new char[]{a,b,c,d});
                if (shortText.equals(doContinue)){
                    continueAdding = true;
                }
            }
            if (i >= 6){
                char a = input.charAt(i-6);
                char b = input.charAt(i-5);
                char c = input.charAt(i-4);
                char d = input.charAt(i-3);
                char e = input.charAt(i-2);
                char f = input.charAt(i-1);
                char g = input.charAt(i);
                String test = String.copyValueOf(new char[]{a,b,c,d,e,f,g});
                if (test.equals(dontContinue)){
                    continueAdding=false;
                }
            }
            if (continueAdding){
                builder.append(input.charAt(i));
            }

        }
        sum = part1(builder.toString());
        return sum;
    }
}