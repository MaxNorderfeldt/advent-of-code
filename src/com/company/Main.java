package com.company;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int basinCounter=0;
        ArrayList<String> input = new ArrayList<String>();

        try {
            File myObj = new File("/Users/max/Documents/AOCInput/inputDay9.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                input.add(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        int height = input.size();
        int width = input.get(0).length();
        int adjLocations = 4;
        int higherLocations = 0;
        int[][] heightMap = new int[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                heightMap[y][x] = Character.getNumericValue(input.get(y).charAt(x));
            }
        }
        ArrayList<Integer> basins = new ArrayList<Integer>();

        ArrayList<String> lowPoints = new ArrayList<String>();
        int currentPos = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                adjLocations = 4;
                higherLocations = 0;
                currentPos = heightMap[y][x];
                if (y - 1 >= 0) {
                    if (currentPos < heightMap[y - 1][x]) {
                        higherLocations++;
                    }
                } else {
                    adjLocations--;
                }
                if (y + 1 < heightMap.length) {
                    if (currentPos < heightMap[y + 1][x]) {
                        higherLocations++;
                    }
                } else {
                    adjLocations--;
                }
                if (x - 1 >= 0) {
                    if (currentPos < heightMap[y][x - 1]) {
                        higherLocations++;
                    }
                } else {
                    adjLocations--;
                }

                if (x + 1 < width) {
                    if (currentPos < heightMap[y][x + 1]) {
                        higherLocations++;
                    } else {
                    }
                } else {
                    adjLocations--;
                }
                if (higherLocations == adjLocations) {
                    lowPoints.add(String.valueOf(y) +" "+ String.valueOf(x));
                }
            }
        }

        int sum = 0;
        ArrayList<String> posToSearch = new ArrayList<String>();
        ArrayList<Integer> basinArray = new ArrayList<Integer>();
        for (String i : lowPoints) {
            posToSearch.add(i);
            //heightMap[Integer.valueOf(i.split(" ")[0])][Integer.valueOf(i.split(" ")[1])] = 9;
            int counter=0;
            basinCounter=0;
            while(posToSearch.size()>0) {
                int y = Integer.valueOf(posToSearch.get(0).split(" ")[0]);
                int x = Integer.valueOf(posToSearch.get(0).split(" ")[1]);
                if (y < heightMap.length - 1) {
                    System.out.println("ultimate test");
                    if (heightMap[y + 1][x] != 9) {
                        System.out.println("ultimateTest2");
                        System.out.println("hit" + y + " " + x);
                        posToSearch.add(String.valueOf(y + 1) +" "+ String.valueOf(x));
                        heightMap[y+1][x] = 9;
                        basinCounter++;
                    }
                }
                if (y > 0) {
                    if (heightMap[y - 1][x] != 9) {
                        System.out.println("hity-end" + y + " " + x);
                        posToSearch.add(String.valueOf(y - 1) +" "+ String.valueOf(x));
                        heightMap[y-1][x] = 9;
                        basinCounter++;
                    }
                }
                if (x < width-1) {
                    if (heightMap[y][x+1] != 9) {
                        System.out.println("hit" + y + " " + x);
                        posToSearch.add(String.valueOf(y) +" "+ String.valueOf(x+1));
                        heightMap[y][x+1] = 9;
                        basinCounter++;
                    }
                }
                if (x > 0) {
                    if (heightMap[y][x-1] != 9) {
                        System.out.println("hitx end" + y + " " + x);
                        posToSearch.add(String.valueOf(y) +" "+ String.valueOf(x-1));
                        heightMap[y][x-1] = 9;
                        basinCounter++;
                    }
                }
                posToSearch.remove(counter);
            }
            System.out.println();
            System.out.println();
            basinArray.add(basinCounter);
            System.out.println(i);
        }
        System.out.println(posToSearch.toString());
        System.out.println(basinCounter);
        System.out.println("----");
        System.out.println(basinArray.toString());
        System.out.println("----");
        Collections.sort(basinArray);
        Collections.reverse(basinArray);
        System.out.println(basinArray.get(0)+" "+basinArray.get(1)+" "+basinArray.get(2));
        System.out.println(basinArray.get(0)*basinArray.get(1)*basinArray.get(2));

    }
}