package com.company;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static void main(String[] args) {
        int[] input = importData();
        int answer= AOC1(input);
        System.out.println(answer);
    }
    public static int AOC1(int[] input) {
        List<Integer> blocks = new ArrayList<>();
        for (int i = 1; i < input.length-1; i++) {
            int block = input[i-1]+input[i]+input[i+1];
            blocks.add(block);
        }
        int counter=0;
        for (int i = 1; i < blocks.size(); i++) {
            if(blocks.get(i)> blocks.get(i-1)) {
                counter++;
            }
        }
        return counter;
    }
    static int[] importData() {
        String data ="";
        try {
            File myObj = new File("/Users/max/Documents/input.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine()+" ";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] array = data.split((" "));
        int[] intArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            intArray[i]=Integer.valueOf(array[i]);
        }
        return intArray;
    }
}
