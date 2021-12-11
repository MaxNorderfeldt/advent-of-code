package mn.adventofcode.year2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
    public static int getResult() {
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

            int x =ventsLocation[i][0];
            int y =0;
            int maxFirstPair = Integer.max(ventsLocation[i][0], ventsLocation[i][2]);
            int minFirstPair = Integer.min(ventsLocation[i][0], ventsLocation[i][2]);
            int firstResult = maxFirstPair-minFirstPair;
            int maxSecondPair = Integer.max(ventsLocation[i][1], ventsLocation[i][3]);
            int minSecondPair = Integer.min(ventsLocation[i][1], ventsLocation[i][3]);
            int secondResult = maxSecondPair - minSecondPair;

            int steps = Integer.max(firstResult, secondResult);

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
        }
        int counter=0;
        int countVents=0;

        for (int x = 0; x < ventsMap.length; x++) {
            for (int y = 0; y < ventsMap.length; y++) {
                if(ventsMap[x][y]>1) {
                    countVents++;
                }
            }

        }
        return countVents;
    }

}
