package mn.adventofcode.year2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelperMethods {
    public static ArrayList<String> readInput(int day) {

        ArrayList<String> input = new ArrayList<String>();
        try {
            File myObj = new File("/Users/max/Documents/AOCInput/inputDay"+day+".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                input.add(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return input;
    }
}
