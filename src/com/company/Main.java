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
        String bingoNumbers = "";

        ArrayList<Integer> numbers = new ArrayList<Integer>();

        try {
            File myObj = new File("/Users/max/Documents/AOCInput/inputDay4.txt");
            Scanner myReader = new Scanner(myObj);
            bingoNumbers += myReader.nextLine();

            while (myReader.hasNextInt()) {
                numbers.add(myReader.nextInt());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String[] tempSplit = bingoNumbers.split(",");
        System.out.println(bingoNumbers);

        int[] bingoNumbersSplited = new int[tempSplit.length];


        for (int i = 0; i < tempSplit.length - 1; i++) {
            bingoNumbersSplited[i] = Integer.valueOf(tempSplit[i]);
        }
        int howmany = bingoNumbers.length() / 25;
        int[][] temp2dArray = new int[5][5];
        ArrayList<BingoCard> bingoCardsObjects = new ArrayList<BingoCard>();
        int x = 0;
        int y = 0;
        int counter =0;
        for (int i = 0; i < numbers.size(); i++) {
            temp2dArray[x][y] = numbers.get(i);
            y++;
            counter++;
            if (y == 5) {
                y = 0;
                x++;
            }
            if(counter==25) {
                y=0;
                x=0;
                bingoCardsObjects.add(new BingoCard(temp2dArray));
                temp2dArray = new int[5][5];
                counter=0;
            }
        }
        System.out.println(numbers);
        System.out.println(bingoNumbersSplited.length);
        int winnerNumber=0;
        int[] victories = new int[bingoCardsObjects.size()];
        int wins = 0;
        outer:
        for (int i = 0; i < bingoNumbersSplited.length; i++) {
            int winner = 0;
            for (BingoCard bingo: bingoCardsObjects
                 ) {
                if(!bingo.win) {
                    bingo.find(bingoNumbersSplited[i]);
                    System.out.println(bingoNumbersSplited[i]);
                    if (bingo.checkWin()) {
                        wins++;
                        bingo.win = true;
                        winnerNumber = bingoNumbersSplited[i];
                        System.out.println(winner + " test");
                        System.out.println(bingo.sumOfNonMarked());
                        System.out.println(winnerNumber * bingo.sumOfNonMarked());
                    }
                    if(wins==bingoCardsObjects.size()) {


                        break outer;
                    }
                }

                winner++;
            }
        }
        for (BingoCard bingo: bingoCardsObjects
             ) {
            bingo.printMask();
        }



    }
}
