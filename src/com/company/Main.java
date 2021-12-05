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
        int[][] ventsMap = new int[1000][1000];
        int[][] ventsLocation = new int[0][0];

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int countLines = 0;

        try {
            File myObj = new File("/Users/max/Documents/AOCInput/inputDay5.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                myReader.nextLine();
                countLines++;
            }
            myObj = new File("/Users/max/Documents/AOCInput/inputDay5.txt");
            myReader = new Scanner(myObj);
            ventsLocation = new int[countLines][4];
            myReader.useDelimiter(",| -> |\n");
            int x = 0;
            int y = 0;
            while (myReader.hasNext()) {
                ventsLocation[y][x]= Integer.valueOf(myReader.nextInt());
                x++;
                if(x==4) {
                    x=0;
                    y++;
                }
            }
            //data += myReader.nextLine();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        for (int i = 0; i < countLines; i++) {
            //5,5 -> 8,2
            //6,4 -> 2,0
            int x =ventsLocation[i][0];
            int y =0;
            int maxFirstPair = Integer.max(ventsLocation[i][0], ventsLocation[i][2]);
            int minFirstPair = Integer.min(ventsLocation[i][0], ventsLocation[i][2]);
            int firstResult = maxFirstPair-minFirstPair;
            int maxSecondPair = Integer.max(ventsLocation[i][1], ventsLocation[i][3]);
            int minSecondPair = Integer.min(ventsLocation[i][1], ventsLocation[i][3]);
            int secondResult = maxSecondPair - minSecondPair;

            int steps = Integer.max(firstResult, secondResult);
            //5,5 -> 8,2
            //6,4 -> 2,0
            x=ventsLocation[i][0];
            y=ventsLocation[i][1];
            for (int j = 0; j <= steps; j++) {
                ventsMap[y][x]++;
                if(ventsLocation[i][0]<ventsLocation[i][2]) {
                    x++;
                } else if (ventsLocation[i][0]>ventsLocation[i][2]) {
                    x--;
                }
                if(ventsLocation[i][1]<ventsLocation[i][3]) {
                    y++;
                } else if (ventsLocation[i][1]>ventsLocation[i][3]) {
                    y--;
                }

            }
/*            if(ventsLocation[i][1]==ventsLocation[i][3]) {
                if(ventsLocation[i][0]> ventsLocation[i][2]) {
                    int temp = ventsLocation[i][0];
                    ventsLocation[i][0] = ventsLocation[i][2];
                    ventsLocation[i][2] = temp;
                }
                System.out.println(i+" test!");
                for (int j = ventsLocation[i][0]; j <= ventsLocation[i][2]; j++) {
                    ventsMap[ventsLocation[i][1]][j]++;
                }
            }*/

        }
        int counter=0;
        int countVents=0;
        for (int[] x : ventsMap)
        {
            for (int y : x)
            {
                System.out.print(y + " ");
            }
            System.out.println();
        }

        for (int x = 0; x < ventsMap.length; x++) {
            for (int y = 0; y < ventsMap.length; y++) {
                if(ventsMap[x][y]>1) {
                    countVents++;
                }
            }

        }
        System.out.println("result "+countVents);
    }
}
