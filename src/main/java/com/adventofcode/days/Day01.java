package com.adventofcode.days;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

import static com.adventofcode.config.Utils.readInput;

public class Day01 {
    public static final Logger logger = LoggerFactory.getLogger(Day01.class);
    public static String SPACE = "   ";
    public static String LEFT = "LEFT";
    public static String RIGHT = "RIGHT";

    public static void main(String[] args) throws IOException {
        logger.info("This is the puzzle from day 1");
        String input = readInput("day01.txt");
        logger.info("Part 1: \n{}", part1(input));
        logger.info("Part 2: \n{}", part2(input));
    }

    public static Map<String, List<Long>> getLists(String input){
        List<Long> leftList = new ArrayList<>();
        List<Long> rightList = new ArrayList<>();
        for (String s : input.split("\n")) {
            String[] fields = s.split(SPACE);
            leftList.add(Long.parseLong(fields[0]));
            rightList.add(Long.parseLong(fields[1]));
        }
        return Map.of(LEFT,leftList,RIGHT,rightList);
    }

    public static long part1(String input) {
        Map<String, List<Long>> myMap = getLists(input);
        List<Long> leftList = myMap.get(LEFT);
        List<Long> rightList = myMap.get(RIGHT);
        Iterator<Long> iterator = leftList.iterator();
        int sum = 0;
        while (iterator.hasNext()){
            Optional<Long> optionalSmallestLeft = leftList.stream().min(Long::compareTo);
            Optional<Long> optionalSmallestRight = rightList.stream().min(Long::compareTo);
            if (optionalSmallestLeft.isPresent() && optionalSmallestRight.isPresent()){
                Long smallestLeft = optionalSmallestLeft.get();
                Long smallestRight = optionalSmallestRight.get();
//                logger.info("{}:{} = {}",smallestLeft,smallestRight, (smallestRight-smallestLeft));
                sum += Math.abs(smallestRight-smallestLeft);
                leftList.remove(leftList.indexOf(smallestLeft));
                rightList.remove(rightList.indexOf(smallestRight));
            }
        }
        return sum;
    }



    public static long part2(String input) {
        Map<String, List<Long>> myMap = getLists(input);
        List<Long> leftList = myMap.get(LEFT);
        List<Long> rightList = myMap.get(RIGHT);
        long sum = 0;
        for (Long aLong : leftList) {
//            logger.info("{} * {}",aLong, rightList.stream().filter(it -> it.equals(aLong)).count());
            sum += aLong * rightList.stream().filter(it -> it.equals(aLong)).count();
        }
        return sum;
    }
}