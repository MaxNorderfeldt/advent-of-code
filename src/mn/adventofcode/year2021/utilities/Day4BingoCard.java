package mn.adventofcode.year2021.utilities;

import java.util.Arrays;

public class Day4BingoCard {
    public int[][] bingo = new int[5][5];
    public int[][] bingoHits = new int[5][5];
    public boolean win = false;

    public Day4BingoCard(int[][] temp2dArray) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.bingo[i][j]=temp2dArray[i][j];
            }

        }
    }

    public void print() {
        System.out.println(Arrays.deepToString(this.bingo));
    }
    public void find(int number) {
        outer:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(this.bingo[i][j]==number) {
                    this.bingoHits[i][j]=1;
                    break outer;
                }
            }

        }
    }
    public void printMask () {
        System.out.println(Arrays.deepToString(bingoHits));
    }

    public int sumOfNonMarked () {
        int sum=0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(bingoHits[i][j]==0) {
                    sum+=bingo[i][j];
                }
            }
        }
        return sum;
    }
    public boolean checkWin () {
        for (int i = 0; i < 5; i++) {
            int counter=0;
            for (int j = 0; j < 5; j++) {
                if(bingoHits[i][j] == 1 ) {
                    counter++;
                    if(counter==5) {
                        return true;
                    }
                }

            }

        }
        for (int i = 0; i < 5; i++) {
            int counter=0;
            for (int j = 0; j < 5; j++) {
                if(bingoHits[j][i] == 1 ) {
                    counter++;
                    if(counter==5) {
                        return true;
                    }
                }

            }
        }
        return false;
    }
}