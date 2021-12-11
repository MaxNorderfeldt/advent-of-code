package mn.adventofcode.year2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day7 {
    public static int getResult() {
        ArrayList<Integer> crabs = new ArrayList<Integer>();
        try {
            File myObj = new File("/Users/max/Documents/AOCInput/inputDay7.txt");
            Scanner myReader = new Scanner(myObj);
            myReader.useDelimiter("[,]");

            while (myReader.hasNext()) {
                int crab = myReader.nextInt();
                crabs.add(crab);
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        Collections.sort(crabs);
        int minPos = crabs.get(0);
        int maxPos = crabs.get(crabs.size() - 1);
        int curPos = 0;

        curPos = crabs.get(0);
        int currentFuel = 0;
        int minFuel = Integer.MAX_VALUE;
        for (int j = minPos; j <= maxPos; j++) {
            currentFuel = 0;
            for (int i = 0; i < crabs.size(); i++) {
                int tempFuel=0;
                for (int k = Math.abs(crabs.get(i) - j); k > 0; k--) {
                    tempFuel+=k;
                }
                currentFuel += Math.abs(tempFuel);
            }
            if (currentFuel < minFuel) {
                minFuel = currentFuel;
            }
        }
        return minFuel;
    }
}
