package mn.adventofcode.year2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day6 {
    public static long getResult () {
        long[] lanternFishes = new long[9];
        //create empty copy of lanternfish, copy over one variable at a time and shift it one step to the left
        //0 goes to 6 and creates a new 8
        //Start from the last position and move left if(i != 0) do thing
        for (int i = 0; i < lanternFishes.length; i++) {
            lanternFishes[i] = 0L;
        }
        int days = 256;
        try {
            File myObj = new File("/Users/max/Documents/AOCInput/inputDay6.txt");
            Scanner myReader = new Scanner(myObj);
            myReader.useDelimiter("[,]");

            while (myReader.hasNext()) {
                int fish = myReader.nextInt();
                lanternFishes[fish]++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i = 0; i < days; i++) {

            long[] tempFishArray = new long[9];
            for (int j = 8; j >= 0; j--) {
                if (j != 0) {
                    tempFishArray[j - 1] = lanternFishes[j];
                } else {
                    tempFishArray[8]=lanternFishes[0];
                    tempFishArray[6]+=lanternFishes[0];

                }
            }
            lanternFishes=tempFishArray;
        }
        long sum = 0;
        for (int i = 0; i < lanternFishes.length; i++) {
            sum+=lanternFishes[i];
        }
        return sum;
    }
}
