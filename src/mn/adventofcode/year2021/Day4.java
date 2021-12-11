package mn.adventofcode.year2021;

import mn.adventofcode.year2021.utilities.Day4BingoCard;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//playing bingo vs a squid

public class Day4 {
    public static int getResult() {
        String data = "";
        String bingoNumbers = "";
        int result=0;

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

        int[] bingoNumbersSplited = new int[tempSplit.length];
        for (int i = 0; i < tempSplit.length - 1; i++) {
            bingoNumbersSplited[i] = Integer.valueOf(tempSplit[i]);
        }
        int howmany = bingoNumbers.length() / 25;
        int[][] temp2dArray = new int[5][5];
        ArrayList<Day4BingoCard> bingoCardsObjects = new ArrayList<Day4BingoCard>();
        int x = 0;
        int y = 0;
        int counter = 0;
        for (int i = 0; i < numbers.size(); i++) {
            temp2dArray[x][y] = numbers.get(i);
            y++;
            counter++;
            if (y == 5) {
                y = 0;
                x++;
            }
            if (counter == 25) {
                y = 0;
                x = 0;
                bingoCardsObjects.add(new Day4BingoCard(temp2dArray));
                temp2dArray = new int[5][5];
                counter = 0;
            }
        }
        int winnerNumber = 0;
        int[] victories = new int[bingoCardsObjects.size()];
        int wins = 0;
        outer:
        for (int i = 0; i < bingoNumbersSplited.length; i++) {
            int winner = 0;
            for (Day4BingoCard bingo : bingoCardsObjects
            ) {
                if (!bingo.win) {
                    bingo.find(bingoNumbersSplited[i]);
                    if (bingo.checkWin()) {
                        wins++;
                        bingo.win = true;
                        winnerNumber = bingoNumbersSplited[i];
                        result= winnerNumber * bingo.sumOfNonMarked();

                    }
                    if (wins == bingoCardsObjects.size()) {
                        break outer;
                    }
                }
                winner++;
            }
        }
        return  result;
    }
}
