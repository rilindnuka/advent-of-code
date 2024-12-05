package com.adventofcode.days;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

import static com.adventofcode.config.Utils.readInput;

public class Day02 {
    public static final Logger logger = LoggerFactory.getLogger(Day02.class);

    public static void main(String[] args) throws IOException {
        logger.info("This is the puzzle from day 2");
        String input = readInput("day02.txt");
//        logger.info("Part 1: \n{}", part1(input));
        logger.info("Part 2: \n{}", part2(input));
    }

    public static List<List<Integer>> createLists(String input) {
        List<List<Integer>> returnList = new ArrayList<>();
        for (String s : input.split("\n")) {
            List<Integer> numberRow = new ArrayList<>();
            for (String number : s.split(" ")) {
                numberRow.add(Integer.valueOf(number));
            }
            returnList.add(numberRow);
        }
        return returnList;
    }

    public static boolean isSafePartOne(List<Integer> integers) {
        boolean safe = true;
        Integer previousNumber = null;
        for (int i = 0; i < integers.size(); i++) {
            Integer currentInteger = integers.get(i);
            if (i == 0) {
                previousNumber = currentInteger;
                continue;
            }
            boolean increasing = integers.get(0) < integers.get(1);
            if ((previousNumber < currentInteger) != increasing) {
                return false;
            }
            if (Math.abs(previousNumber - currentInteger) > 3) {
                return false;
            }
            if (currentInteger == previousNumber) {
                return false;
            }
            previousNumber = currentInteger;
        }
        return safe;
    }

    public static boolean isSafePartTwo(List<Integer> integers) {
        boolean safe = true;
        Integer previousNumber = null;
        int currentIndex = 0;

        for (int i = 0; i < integers.size(); i++) {
            Integer currentInteger = integers.get(i);
            if (i == 0) {
                previousNumber = currentInteger;
                continue;
            }
            boolean increasing = integers.get(0) < integers.get(1);
            if ((previousNumber < currentInteger) != increasing) {
                safe = false;
                currentIndex = i;
            }
            if (Math.abs(previousNumber - currentInteger) > 3) {
                safe = false;
                currentIndex = i;

            }
            if (currentInteger == previousNumber) {
                safe = false;
                currentIndex = i;
            }
            previousNumber = currentInteger;
        }
        if (!safe) {

            for (int i = 0; i < integers.size(); i++) {
                ArrayList<Integer> oldIntegers = new ArrayList<>(integers);
                oldIntegers.remove(i);
                if (isSafePartOne(oldIntegers)){
                    return true;
                }


            }
        }
        return safe;
    }

    public static long part1(String input) {
        List<List<Integer>> lists = createLists(input);
        int sum = 0;
        for (List<Integer> list : lists) {
            if (isSafePartOne(list)) {
                sum++;
            }
        }
        return sum;
    }


    public static long part2(String input) {
        List<List<Integer>> lists = createLists(input);
        int sum = 0;
        for (List<Integer> list : lists) {
            if (isSafePartTwo(list)) {
                sum++;
            }
        }
        return sum;
    }
}