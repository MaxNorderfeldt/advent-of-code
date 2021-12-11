package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<String>();

        try {
            File myObj = new File("/Users/max/Documents/AOCInput/inputDay11.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                input.add(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int height = input.size();
        int width = input.get(0).length();
        int[][] squids = new int[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                squids[y][x] = Character.getNumericValue(input.get(y).charAt(x));
            }
        }
        System.out.println(Arrays.deepToString(squids));
        int steps = 1000;
        int hits = 0;
        int totalHits=0;
        for (int step = 1; step <= steps; step++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    squids[y][x]++;
                }
            }
            do {
                System.out.println("true!");
                hits = 0;
                for (int y = 0; y < height; y++) {
                    for (int x = 0; x < width; x++) {
                        if (squids[y][x] > 9 && squids[y][x] < 19) {
                            hits++;

                            totalHits++;
                            for (int locX = -1; locX <= 1; locX++) {
                                for (int locY = -1; locY <= 1; locY++) {
                                    if (y + locY >= 0 && y + locY < width && x + locX >= 0 && x + locX < width) {
                                        squids[y + locY][x + locX]++;
                                    }
                                }
                            }
                            squids[y][x] = 20;
                        }
                    }
                    System.out.println(hits + "hits");
                }

            } while (hits > 0);
            int lights=0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (squids[y][x] > 9) {
                        lights++;
                        if(lights>=width*height) {
                            System.out.println("result "+step);
                            return;
                        }
                    }
                }
            }
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (squids[y][x] > 9) {
                        squids[y][x] = 0;
                    }
                }
            }

            System.out.println(Arrays.deepToString(squids));
        }
        System.out.println(totalHits);
    }
}

