package com.company;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static void main(String[] args) {
        String data ="";
        try {
            File myObj = new File("/Users/max/Documents/AOCInput/inputDay2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data += myReader.nextLine()+" ";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(data);
        String[] array = data.split((" "));
        int distance;
        String command;
        int horizontal=0;
        int depth=0;
        int aim=0;
        for (int i = 0; i < array.length; i+=2) {
                command = array[i];
                distance = Integer.valueOf(array[i+1]);


            switch(command)
            {
                case "forward" :
                    horizontal+=distance;
                    depth += distance*aim;
                    break;
                case "up" :
                    aim-=distance;
                    break;
                case "down" :
                    aim+=distance;
                    break;

            }
        }
        System.out.println(depth*horizontal);
    }
}
