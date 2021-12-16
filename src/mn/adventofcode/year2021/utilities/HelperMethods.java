package mn.adventofcode.year2021.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//helper class for day4 challenge

public class HelperMethods {
    public static ArrayList<String> readInput(int day) {


        ArrayList<String> input = new ArrayList<>();
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

    public static ArrayList<Integer> readInputInt(int day) {
        ArrayList<Integer> input = new ArrayList<>();
        try {
            File myObj = new File("Users/max/Documents/AOCInput/inputDay"+day+".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextInt()) {
                input.add(myReader.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return input;
    }
    public static String readInputString(int day) {
        String input = "";
        try {
            File myObj = new File("Users/max/Documents/AOCInput/inputDay"+day+".txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                input+= myReader.nextLine()+" ";
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return input;
    }
}
