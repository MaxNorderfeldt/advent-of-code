package mn.adventofcode.year2021;

import mn.adventofcode.year2021.utilities.HelperMethods;

import java.util.ArrayList;

public class Day15 {
    public static int getResult() {
        ArrayList<String> input = HelperMethods.readInput(15);
        int[][] riskMap = new int[input.size()][input.get(0).length()];
        for (int y = 0; y < riskMap.length; y++) {
            for (int x = 0; x < riskMap[0].length; x++) {
                riskMap[y][x] = Character.getNumericValue(input.get(y).charAt(x));
            }
        }
        int x = 0;
        int y = 0;
        int sum = 0;
        int smallestSum = Integer.MAX_VALUE;
        int depth = 5;

        for (int i = 0; i < riskMap.length + riskMap[0].length; i++) {
            for (int j = 0; j < riskMap.length + riskMap[0].length; j++) {
                for (int k = 0; k < riskMap.length + riskMap[0].length; k++) {
                    int counter = 0;
                    x = 0;
                    y = 0;
                    sum = 0;
                    while (y < riskMap.length - 1 || x < riskMap[0].length - 1) {
                        if (y == riskMap.length - 1) {
                            x++;
                        } else if (x == riskMap[0].length - 1) {
                            y++;
                        } else {
                            int sumRight = 0;
                            int sumDown = 0;
                            sumRight += riskMap[y][x + 1];
                            sumDown += riskMap[y + 1][x];

                            if (y < riskMap.length - 2 && x < riskMap[0].length - 2) {
                                sumRight += Integer.min(riskMap[y][x + 2], riskMap[y + 1][x + 1]);
                                sumDown += Integer.min(riskMap[y + 2][x], riskMap[y + 1][x + 1]);
                            }

                            if (sumRight < sumDown) {
                                if (counter == i || counter == j || counter == k) {
                                    y += 1;
                                } else {
                                    x += 1;
                                }

                            } else {
                                if(counter == i || counter == j || counter == k) {
                                    x+= 1;
                                } else {
                                    y += 1;
                                }
                            }
                        }
                        sum += riskMap[y][x];
                        counter++;

                    }
                    if (sum < smallestSum) {
                        smallestSum = sum;
                    }
                }

                System.out.println(smallestSum + " smallestSum");
                }

        }
        return 0;
    }
}
