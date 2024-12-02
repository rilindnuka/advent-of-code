package com.adventofcode.days;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

import static com.adventofcode.config.Utils.readInput;

public class Day01 {
    public static final Logger logger = LoggerFactory.getLogger(Day01.class);
    public static void main(String[] args) throws IOException {
        logger.info("This is the puzzle from day 1");
        String input = readInput("day01.txt");
        logger.info("Part 1: \n{}", part1(input));
        logger.info("Part 2: \n{}", part2(input));
    }

    public static int part1(String input) {
        // Solution for Part 1
        return 0;
    }

    public static int part2(String input) {
        // Solution for Part 2
        return 0;
    }
}