package mn.adventofcode;

import mn.adventofcode.year2021.Day1;
import mn.adventofcode.year2021.Day11;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*;

public class Main {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        //Test 1
        System.out.println("methodTest "+ Day1.getResult());
        long endTime = System.nanoTime();
        long duration = (endTime - startTime)/1000_000;
        System.out.println(duration);

        //Test 11
         startTime = System.nanoTime();
        System.out.println("methodTest "+Day11.getResult());
        endTime = System.nanoTime();

        duration = (endTime - startTime)/1000_000;
        System.out.println(duration);

    }
}

