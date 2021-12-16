package mn.adventofcode.year2021;

import mn.adventofcode.year2021.utilities.HelperMethods;

import java.util.ArrayList;
import java.util.Arrays;

public class Day13 {
    public static void getResult() {
        ArrayList<String> input = HelperMethods.readInput(13);
        int xMax = 0;
        int yMax = 0;
        ArrayList<String> foldInstructions = new ArrayList<>();
        int size = 0;
        for (int i = 0; i < input.size(); i++) {
            String[] tempArray = input.get(i).split("[, ]");
            if (tempArray[0].length() == 0) {
                continue;
            }
            if (tempArray[0].contains("fold")) {
                foldInstructions.add(tempArray[2]);
            } else {
                int tempX = Integer.valueOf(tempArray[0]);
                int tempY = Integer.valueOf(tempArray[1]);
                size++;

                if (Integer.valueOf(tempArray[0]) > xMax) {
                    xMax = tempX;
                }
                if (Integer.valueOf(tempArray[1]) > yMax) {
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

        for (int i = 0; i < size; i++) {
            String[] tempArray = input.get(i).split(",");
            if (tempArray[0].length() == 0) {
                continue;
            }
            if (!tempArray[0].contains("fold")) {
                int tempX = Integer.valueOf(tempArray[0]);
                int tempY = Integer.valueOf(tempArray[1]);
                transparentPaper[tempY][tempX] = '#';
            }
        }

        char[][] foldedPaper = transparentPaper;
        for (int i = 0; i < foldInstructions.size(); i++) {
            String[] tempArray = foldInstructions.get(i).split("=");
            foldedPaper = foldThis(foldedPaper, Integer.valueOf(tempArray[1]), foldInstructions.get(i).charAt(0));

        }
        //Prints the result
        System.out.println(Arrays.deepToString(foldedPaper).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
    }

    public static char[][] foldThis(char[][] paperToFold, int foldAt, char instr) {
        char[][] foldedPaper = new char[0][0];
        if (instr == 'y') {
            //The addToTop was added since the foldAt wasnt centered at the Y axis
            int addToTop = 0;
            if (foldAt > (paperToFold.length - 1 - foldAt)) {
                addToTop += (foldAt - ((paperToFold.length - 1) / 2 - 1));
            }

            foldedPaper = new char[foldAt][paperToFold[0].length];
            //First the old values that would be kept is copied over
            for (int y = 0; y < foldedPaper.length; y++) {
                for (int x = 0; x < foldedPaper[0].length; x++) {
                    foldedPaper[y][x] = paperToFold[y][x];
                }
            }
            //Code belows mirrors the part that is folded over
            for (int y = 0; y < foldAt - addToTop; y++) {
                for (int x = 0; x < foldedPaper[0].length; x++) {
                    if (foldedPaper[foldAt - 1 - y][x] != '#') {
                        foldedPaper[foldAt - 1 - y][x] = paperToFold[foldAt + 1 + y][x];
                    }
                }
            }
        }
        if (instr == 'x') {
            foldedPaper = new char[paperToFold.length][foldAt];
            for (int y = 0; y < foldedPaper.length; y++) {
                for (int x = 0; x < foldedPaper[0].length; x++) {
                    foldedPaper[y][x] = paperToFold[y][x];
                }
            }

            for (int y = 0; y < foldedPaper.length; y++) {
                for (int x = 0; x < foldedPaper[0].length; x++) {
                    if (foldedPaper[y][foldAt - 1 - x] != '#') {
                        foldedPaper[y][foldAt - 1 - x] = paperToFold[y][foldAt + 1 + x];
                    }
                }
            }
        }
        return foldedPaper;
    }
}
