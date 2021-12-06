package com.company;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static void main(String[] args) {

        try {
            File myObj = new File("/Users/max/Documents/AOCInput/inputDay5.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                myReader.nextLine();
            }
            myObj = new File("/Users/max/Documents/AOCInput/inputDay5.txt");
            myReader = new Scanner(myObj);
            myReader.useDelimiter(",| -> |\n");

            while (myReader.hasNext()) {

            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
