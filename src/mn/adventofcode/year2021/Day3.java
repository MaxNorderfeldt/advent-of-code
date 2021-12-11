package mn.adventofcode.year2021;

import mn.adventofcode.year2021.utilities.HelperMethods;

import java.util.ArrayList;

/*find the most common binary in each column
oxygen generator rating  = most common binary, then keep only numbers with that bit in it
epsilon rate = opposite of oxygen*/

public class Day3 {
    public static int getResult() {
        String data = "";
        String x = "";
        String y = "";

        ArrayList<String> input = HelperMethods.readInput(3);

        ArrayList<String> arrayCopy = new ArrayList<>(input);
        int[] binaryCounter = new int[input.get(0).length()];

        char mostCommon = '0';
        char leastCommon = '0';
        outer:
        for (int i = 0; i < binaryCounter.length; i++) {
            for (String binary : input) {
                //counts 1s and 0s at i location
                if (binary.charAt(i) == '1') {
                    binaryCounter[i]++;
                } else {
                    binaryCounter[i]--;
                }
            }
            //stores the binary that is most common
            if (binaryCounter[i] >= 0) {
                mostCommon = '1';
            } else {
                mostCommon = '0';
            }
            for (int j = 0; j < input.size(); j++) {
                if (input.get(j).charAt(i) != mostCommon) {
                    //removes the least common  binaries
                    input.remove(j);
                    if (input.size() == 1) {
                        x = input.get(0);
                        break outer;
                    }
                    j--;
                }
            }
            if (i == binaryCounter.length - 1) {
                i = 0;
            }
        }
        binaryCounter = new int[input.get(0).length()];
        outerTop:
        for (int i = 0; i < binaryCounter.length; i++) {
            for (String binary : arrayCopy) {
                if (binary.charAt(i) == '1') {
                    binaryCounter[i]++;
                } else {
                    binaryCounter[i]--;
                }
            }
            if (binaryCounter[i] < 0) {
                leastCommon = '1';
            } else {
                leastCommon = '0';
            }
            for (int j = 0; j < arrayCopy.size(); j++) {
                if (arrayCopy.get(j).charAt(i) != leastCommon) {
                    y = arrayCopy.get(j);
                    arrayCopy.remove(j);
                    if (arrayCopy.size() == 1) {
                        y = arrayCopy.get(0);
                        break outerTop;
                    }
                    j--;
                }
            }
            if (i == binaryCounter.length - 1) {
                i = 0;
            }
        }
        //convert binary to decimal
        int result = Integer.valueOf(x, 2) * Integer.valueOf(y, 2);
        return result;
    }
}
