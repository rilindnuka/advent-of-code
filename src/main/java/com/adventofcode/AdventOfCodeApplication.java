package com.adventofcode;

import com.adventofcode.config.Utils;
import com.adventofcode.days.Day01;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.List;

@SpringBootApplication
public class AdventOfCodeApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(AdventOfCodeApplication.class, args);
        Day01.main(args);
    }

}
