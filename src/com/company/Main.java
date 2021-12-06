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
            File myObj = new File("C:\\Temp\\inputDay6.txt");
            Scanner myReader = new Scanner(myObj);
            myReader.useDelimiter("[,]");

            while (myReader.hasNext()) {
                int fish = myReader.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
