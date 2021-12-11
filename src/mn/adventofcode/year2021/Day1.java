package mn.adventofcode.year2021;

import java.util.ArrayList;
import java.util.List;

//Objective is to check 3 measurements and check if those 3 sums are larger than the previous 3

public class Day1 {
    public static int getResult() {
        ArrayList<Integer> input= HelperMethods.readInputInt(1);
        int inputSize = input.size();
        List<Integer> sumOfMeasurements = new ArrayList<>();
        //the code below adds 3 measurements and adds them to list
        for (int i = 1; i < inputSize - 1; i++) {
            sumOfMeasurements.add(input.get(i - 1) + input.get(i) + input.get(i + 1));
        }
        int largerSums = 0;
        //The code below compares the sum of 3 measurements with the previous one
        for (int i = 1; i < sumOfMeasurements.size(); i++) {
            if (sumOfMeasurements.get(i) > sumOfMeasurements.get(i - 1)) {
                largerSums++;
            }
        }
        return largerSums;
    }
}
