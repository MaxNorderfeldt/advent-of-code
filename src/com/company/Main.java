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
        ArrayList<String> input = new ArrayList<String>();
        ArrayList<String> output = new ArrayList<String>();

        try {
            File myObj = new File("C:\\Temp\\inputDay8.txt");
            Scanner myReader = new Scanner(myObj);
            myReader.useDelimiter("\\|");

            int counter=0;


            System.out.println();

            while (myReader.hasNext()) {
                if(counter%2==0) {
                    input.add(myReader.next());
                }else {
                    output.add(myReader.next());
                }
                counter++;
            }


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (String test: input
             ) {
            System.out.println(test+" input");

        }
        for (String test: output
             ) {
            System.out.println(test +" output");
        }

        System.out.println(output.size()+"test inputsize");
        int countKnownOutput=0;
        int outputSize=0;
        ArrayList<String> inputArray= new ArrayList<String>();

        for (int i = 0; i < output.size(); i++) {
            String[] tempOutput = output.get(i).split(" ");
            for (String outputString : tempOutput
                 ) {
                System.out.println(outputString+" test");
                outputSize=outputString.length();
                System.out.println(outputSize);
                if(outputSize==2 || outputSize==3 || outputSize==4 || outputSize == 7) {
                    countKnownOutput++;
                    System.out.println("hit");
                }

            }
        }
        System.out.println(countKnownOutput);

    }
}
