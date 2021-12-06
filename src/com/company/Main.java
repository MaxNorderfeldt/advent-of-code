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
        long[] lanternFishes = new long[9];
        //create empty copy of lanternfish, copy over one variable at a time and shift it one step to the left
        //0 goes to 6 and creates a new 8
        //Start from the last position and move left if(i != 0) do thing
        for (int i = 0; i < lanternFishes.length; i++) {
            lanternFishes[i] = 0L;
        }
        int days = 256;
        try {
            File myObj = new File("C:\\Temp\\inputDay6.txt");
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

        System.out.println(lanternFishes.length);
        long sum = 0;
        for (int i = 0; i < lanternFishes.length; i++) {
            System.out.println(lanternFishes[i]);
            sum+=lanternFishes[i];
        }
        System.out.println("sum"+ sum);
    }
}
