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
        while (y < riskMap.length && x < riskMap[0].length) {
            int sumRight = 0;
            int sumDown = 0;
            sumRight+=riskMap[y][x+1];
            sumRight+=Integer.min(riskMap[y][x+2], riskMap[y+1][x+1]);
            sumDown+=riskMap[y+1][x];
            sumDown+=Integer.min(riskMap[y+2][x],riskMap[y+1][x+1]);
            if(sumRight<sumDown) {
                x+=1;
            } else {
                y+=1;
            }
            sum+=riskMap[y][x];
            System.out.println(riskMap[y][x]);
        }

        return 0;
    }
}
