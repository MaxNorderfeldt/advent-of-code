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
        int size = 0;
        for (int i = 0; i < input.size(); i++) {
            String[] tempArray = input.get(i).split("[, ]");
            if (tempArray[0].length() == 0) {
                continue;
            }
            System.out.println(tempArray[0]);
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
        System.out.println(yMax + "ymax");

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
                System.out.println(tempX + " x");
                System.out.println(tempY + " y");

                transparentPaper[tempY][tempX] = '#';
            }
        }

        char[][] foldedPaper= transparentPaper;
        System.out.println(Arrays.deepToString(foldedPaper).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

        for (int i = 0; i < foldInstructions.size(); i++) {
            String[] tempArray = foldInstructions.get(i).split("=");
            System.out.println("----");
            foldedPaper=foldThis(foldedPaper, Integer.valueOf(tempArray[1]), foldInstructions.get(i).charAt(0));
            System.out.println(Arrays.deepToString(foldedPaper).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

        }


        System.out.println(foldInstructions.toString());

        int counter = 0;
        for (int j = 0; j < foldedPaper.length; j++) {
            for (int i = 0; i < foldedPaper[0].length; i++) {
                if (foldedPaper[j][i] == '#') {
                    counter++;
                }
            }
        }
        System.out.println("--------");

        System.out.println("final");

        return counter;
    }
    public static char[][] foldThis(char[][] paperToFold, int foldAt, char instr) {
        char[][] foldedPaper;

        if(instr=='y') {
            System.out.println("ytest--------");
            System.out.println(foldAt);
            System.out.println(paperToFold.length);
            int temper=0;
            if(paperToFold.length-foldAt>foldAt) {
               temper+=1;
            }
            foldedPaper = new char[foldAt+temper][paperToFold[0].length];

            for (int y = 0; y < foldAt; y++) {
                for (int x = 0; x < foldedPaper[0].length; x++) {
                    foldedPaper[foldAt-y-1][x] = paperToFold[foldAt+y-1][x];
                    if (foldedPaper[y][x] == '.') {
                        foldedPaper[y][x] = paperToFold[y][x];
                    }
                }
            }
        } else {
            int temper=0;
            foldedPaper = new char[paperToFold.length][foldAt];
            for (int y = 0; y < foldedPaper.length; y++) {
                for (int x = 0; x < foldAt; x++) {
                    foldedPaper[y][x] = paperToFold[y][paperToFold[0].length-x-1];
                    if (foldedPaper[y][x] == '.') {
                        foldedPaper[y][x] = paperToFold[y][x];
                    }
                }
            }
        }
        return foldedPaper;
    }
}
