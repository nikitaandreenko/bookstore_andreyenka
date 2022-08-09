package com.company;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Test {
    private static final Logger log = LogManager.getLogger(Test.class);

    public static void main(String[] args) {
        double avgMark = getRatio(10, 0, Level.DEBUG);
        System.out.println(avgMark);

        double avgSalary = getRatio(100000, 0, Level.WARN);
        System.out.println(avgSalary);
    }

    public static double getRatio(int a, int b, Level level) {
        if (b == 0) {
            log.log(level, "Argument qu 0, {}", b);
        }
        return (double) a / b;
    }
}
