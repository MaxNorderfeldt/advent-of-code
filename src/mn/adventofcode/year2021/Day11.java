package mn.adventofcode.year2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Day11 {
    public static int getResult() {
        ArrayList<String> input =HelperMethods.readInput(11);
        int height = input.size();
        int width = input.get(0).length();
        int[][] squids = new int[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                squids[y][x] = Character.getNumericValue(input.get(y).charAt(x));
            }
        }
        int steps = 1000;
        int hits = 0;
        int totalHits = 0;
        for (int step = 1; step <= steps; step++) {
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    squids[y][x]++;
                }
            }
            do {
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
                }

            } while (hits > 0);
            int lights = 0;
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (squids[y][x] > 9) {
                        lights++;
                        if (lights >= width * height) {
                            return step;
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
        }
        return 0;
    }
}
