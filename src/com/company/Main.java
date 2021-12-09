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
        ArrayList<String> data = new ArrayList<String>();
        ArrayList<String> outputs = new ArrayList<String>();
        ArrayList<String> inputs = new ArrayList<String>();

        try {
            File myObj = new File("/Users/max/Documents/AOCInput/inputDay8.txt");
            Scanner myReader = new Scanner(myObj);
            int counter = 0;


            System.out.println();

            while (myReader.hasNext()) {
                data.add(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String number = "";
        long sum = 0;
        for (String line : data
        ) {
            String[] temp = line.split("\\|");
            inputs.add(temp[0]);
            outputs.add(temp[1]);
        }
        int countNumbers = 0;
        for (int i = 0; i < inputs.size(); i++) {
            String[] temp = inputs.get(i).split(" ");
            String one = "", seven = "", four = "", eight = "";
            ArrayList<String> sixes = new ArrayList<String>();
            ArrayList<String> fives = new ArrayList<String>();
            for (String input : temp
            ) {
                int l = input.length();
                //code below gets the known numbers

                if (l == 2) {
                    one = input;
                } else if (l == 3) {
                    seven = input;
                } else if (l == 4) {
                    four = input;
                } else if (l == 7) {
                    eight = input;
                } else if (l == 6) {
                    sixes.add(input);
                } else if (l == 5) {
                    fives.add(input);
                }

            }
            char a = ' ';
            String tempChar = seven;
            for (char part : one.toCharArray()
            ) {
                tempChar = tempChar.replace(String.valueOf(part), "");
            }
            a = tempChar.charAt(0);


            char g = ' ';
            //code below gets the nine so that i can use it to get G
            String nine = "";
            for (String sixLetterNumber : sixes
            ) {
                int counter = 0;
                for (int j = 0; j < four.length(); j++) {
                    String testI = String.valueOf(four.charAt(j));
                    if (sixLetterNumber.contains(testI)) {
                        counter++;
                    } else {
                        break;
                    }
                    if (counter == 4) {
                        nine = sixLetterNumber;
                    }
                }
            }

            tempChar = nine;
            for (char part : four.toCharArray()
            ) {
                tempChar = tempChar.replace(String.valueOf(part), "");
                tempChar = tempChar.replace(String.valueOf(a), "");
            }
            g = tempChar.charAt(0);

            char e = ' ';

            tempChar = eight;
            for (char part : nine.toCharArray()
            ) {
                tempChar = tempChar.replace(String.valueOf(part), "");
            }
            e = tempChar.charAt(0);


            String three = "";
            for (String fiveLetterNumber : fives
            ) {
                int counter = 0;
                for (int j = 0; j < one.length(); j++) {
                    String testI = String.valueOf(one.charAt(j));
                    if (fiveLetterNumber.contains(testI)) {
                        counter++;
                    } else {
                        break;
                    }
                    if (counter == 2) {
                        three = fiveLetterNumber;
                    }
                }
            }
            tempChar = three;
            char d = ' ';
            for (char part : seven.toCharArray()
            ) {
                tempChar = tempChar.replace(String.valueOf(part), "");
                tempChar = tempChar.replace(String.valueOf(g), "");
            }
            d = tempChar.charAt(0);

            tempChar = four;
            char b = ' ';
            for (char part : one.toCharArray()
            ) {
                tempChar = tempChar.replace(String.valueOf(part), "");
                tempChar = tempChar.replace(String.valueOf(d), "");
            }
            b = tempChar.charAt(0);
            String de = String.valueOf(d) + e;
            String six = "";
            for (String sixLetterNumber : sixes
            ) {
                int counter = 0;
                for (int j = 0; j < de.length(); j++) {
                    String testI = String.valueOf(de.charAt(j));
                    if (sixLetterNumber.contains(testI)) {
                        counter++;
                    } else {
                        break;
                    }
                    if (counter == 2) {
                        six = sixLetterNumber;
                    }
                }
            }
            tempChar = six;
            char f = ' ';
            tempChar = tempChar.replace(String.valueOf(g), "");
            tempChar = tempChar.replace(String.valueOf(a), "");
            tempChar = tempChar.replace(String.valueOf(d), "");
            tempChar = tempChar.replace(String.valueOf(e), "");
            tempChar = tempChar.replace(String.valueOf(b), "");

            f = tempChar.charAt(0);

            tempChar = seven;
            char c = ' ';
            tempChar = tempChar.replace(String.valueOf(a), "");
            tempChar = tempChar.replace(String.valueOf(f), "");

            c = tempChar.charAt(0);

            System.out.println(outputs.size());

            for (String t : outputs.get(i).split(" ")
            ) {
                //System.out.println(t);
            }
            number = "";
            String[] splitOutput = outputs.get(i).split(" ");

            for (int j = 0; j < splitOutput.length; j++) {
                String word = splitOutput[j];
                // System.out.println(word);
                int l = word.length();
                if (l == 2) {
                    number += 1;
                } else if (l == 3) {
                    number += 7;
                } else if (l == 4) {
                    number += 4;
                } else if (l == 7) {
                    number += 8;
                } else if (word.contains(Character.toString(a)) && word.contains(Character.toString(b)) && word.contains(Character.toString(c)) && word.contains(Character.toString(d)) && word.contains(Character.toString(f)) && word.contains(Character.toString(g))) {
                    number += 9;
                } else if (word.contains(Character.toString(a)) && word.contains(Character.toString(b)) && word.contains(Character.toString(c)) && word.contains(Character.toString(e)) && word.contains(Character.toString(f)) && word.contains(Character.toString(g))) {
                    number += 0;
                } else if (word.contains(Character.toString(a)) && word.contains(Character.toString(b)) && word.contains(Character.toString(d)) && word.contains(Character.toString(e)) && word.contains(Character.toString(f)) && word.contains(Character.toString(g))) {
                    number += 6;
                } else if (word.contains(Character.toString(a)) && word.contains(Character.toString(b)) && word.contains(Character.toString(d)) && word.contains(Character.toString(f)) && word.contains(Character.toString(g))) {
                    number += 5;
                } else if (word.contains(Character.toString(a)) && word.contains(Character.toString(c)) && word.contains(Character.toString(d)) && word.contains(Character.toString(f)) && word.contains(Character.toString(g))) {
                    number += 3;
                }else if (word.contains(Character.toString(a)) && word.contains(Character.toString(c)) && word.contains(Character.toString(d)) && word.contains(Character.toString(e)) && word.contains(Character.toString(g))) {
                    number += 2;
                }

                System.out.println(number);
            }
            System.out.println(sum += Integer.valueOf(number));
        }


    }


}

