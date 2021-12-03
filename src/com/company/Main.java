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
        String data = "";
        List<String> array = new ArrayList<String>();
        String x="";
        String y ="";

        try {
            File myObj = new File("/Users/max/Documents/AOCInput/inputDay3.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                array.add(myReader.nextLine());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        List<String> arrayCopy = new ArrayList<>(array);
        System.out.println(arrayCopy.size());
        int[] binaryCounter = new int[array.get(0).length()];

        char tempChar = '0';

        outer:
        for (int i = 0; i < binaryCounter.length; i++) {
            for (String binary : array) {
                if (binary.charAt(i) == '1') {
                    binaryCounter[i]++;
                } else {
                    binaryCounter[i]--;
                }
            }
            if (binaryCounter[i] >= 0) {
                tempChar = '1';
            } else {
                tempChar = '0';
            }

            for (int j = 0; j < array.size(); j++) {
                if(array.get(j).charAt(i)!=tempChar) {
                    System.out.println(array.get(j));
                    array.remove(j);
                    System.out.println(array.size());
                    if(array.size()==1){
                        x=array.get(0);
                        break outer;
                    }
                    j--;

                }
            }
            if(i == binaryCounter.length-1) {
                i=0;
            }
        }
        binaryCounter = new int[array.get(0).length()];
        System.out.println(binaryCounter.length);
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
                tempChar = '1';
            } else {
                tempChar = '0';
            }
            for (int j = 0; j < arrayCopy.size(); j++) {
                if (arrayCopy.get(j).charAt(i) != tempChar) {
                    System.out.println(arrayCopy.get(j));
                    y=arrayCopy.get(j);
                    arrayCopy.remove(j);
                    if(arrayCopy.size()==1){
                        y=arrayCopy.get(0);
                        break outerTop;
                    }
                    j--;
                }
            }
            if(i == binaryCounter.length-1) {
                i=0;
            }
        }
        System.out.println("------");
        System.out.println(x);
        System.out.println(y);
        int result = Integer.valueOf(x,2)*Integer.valueOf(y,2);
        System.out.println(result);

    }

}
