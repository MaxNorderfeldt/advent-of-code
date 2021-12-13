package mn.adventofcode.year2021;

import mn.adventofcode.year2021.utilities.HelperMethods;

import java.util.ArrayList;
import java.util.Arrays;

public class Day13 {
    public static int getResult() {


        ArrayList<String> input = HelperMethods.readInput(13);
        int xMax = 0;
        int yMax = 0;
        ArrayList<String> foldInstructions = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            String[] tempArray = input.get(i).split(",");
            if(tempArray[0].length()==0) {
                continue;
            }
            System.out.println(tempArray[0]);
            if (tempArray[0].contains("fold")) {
                System.out.println("test");
            } else {
                int tempX = Integer.valueOf(tempArray[0]);
                int tempY = Integer.valueOf(tempArray[1]);

                if (Integer.valueOf(tempArray[0]) > xMax) {
                    xMax = tempX;
                }
                if (Integer.valueOf(tempArray[1]) > xMax) {
                    yMax = tempY;
                }
            }


        }
        //one is added since indexing starts at 0
        yMax += 1;
        xMax += 1;
        char[][] transparentPaper = new char[yMax][xMax];

        for (int j = 0; j < yMax; j++) {
            for (int i = 0; i < xMax; i++) {
                transparentPaper[j][i] = '.';
            }
        }

        for (int i = 0; i < input.size(); i++) {
            String[] tempArray = input.get(i).split(",");
            int tempX = Integer.valueOf(tempArray[0]);
            int tempY = Integer.valueOf(tempArray[1]);

            transparentPaper[tempY][tempX] = '#';
        }
        System.out.println(Arrays.deepToString(transparentPaper));

        char[][] foldedPaper = new char[yMax / 2][xMax];

        for (int y = 0; y < foldedPaper.length; y++) {
            for (int x = 0; x < xMax; x++) {
                foldedPaper[y][x] = transparentPaper[yMax - y - 1][x];
                if (foldedPaper[y][x] == '.') {
                    foldedPaper[y][x] = transparentPaper[y][x];
                }
            }
        }
        System.out.println(Arrays.deepToString(foldedPaper));


        int counter = 0;
        System.out.println(foldedPaper.length);
        for (int j = 0; j < foldedPaper.length; j++) {
            for (int i = 0; i < xMax; i++) {
                if (foldedPaper[j][i] == '#') {
                    counter++;
                }
            }
        }
        return counter;
    }
}
