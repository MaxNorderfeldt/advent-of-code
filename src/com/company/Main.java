package com.company;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> input = new ArrayList<String>();

        try {
            File myObj = new File("/Users/max/Documents/AOCInput/inputDay10.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                input.add(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        ArrayList<Character> brackets = new ArrayList<Character>();
        ArrayList<Long> results = new ArrayList<Long>();
        ArrayList<Character> syntaxErrors = new ArrayList<Character>();
        char currentChar = ' ';
        Long sum = 0l;

        for (String line : input) {
            boolean switcher=true;
            for (int i = 0; i < line.length(); i++) {
                currentChar = line.charAt(i);
                if (currentChar == ')') {
                    if (brackets.get(brackets.size() - 1) == '(') {
                        brackets.remove(brackets.size() - 1);
                    } else {
                        syntaxErrors.add(currentChar);
                        switcher=false;
                        break;
                    }
                } else if (currentChar == '}') {
                    if (brackets.get(brackets.size() - 1) == '{') {
                        brackets.remove(brackets.size() - 1);
                    } else {
                        syntaxErrors.add(currentChar);
                        switcher=false;
                        break;
                    }
                } else if (currentChar == '>') {
                    if (brackets.get(brackets.size() - 1) == '<') {
                        brackets.remove(brackets.size() - 1);
                    } else {
                        syntaxErrors.add(currentChar);
                        switcher=false;
                        break;
                    }
                } else if (currentChar == ']') {
                    if (brackets.get(brackets.size() - 1) == '[') {
                        brackets.remove(brackets.size() - 1);
                    } else {
                        syntaxErrors.add(currentChar);
                        switcher=false;
                        break;
                    }
                } else {
                    brackets.add(currentChar);
                }
            }
            sum = 0l;
            for (int i = brackets.size()-1; i >= 0; i--) {
                currentChar = brackets.get(i);
                System.out.print(currentChar);
                int charValue = 0;
                if (currentChar == '(') {
                    charValue = 1;
                } else if (currentChar == '[') {
                    charValue = 2;
                } else if (currentChar == '{') {
                    charValue = 3;
                } else if (currentChar == '<') {
                    charValue = 4;
                }
                sum = sum*5;
                sum += charValue;
            }
            System.out.println();
            if (sum >= 0 && switcher==true) {
                results.add(sum);
            }
            brackets = new ArrayList<Character>();
        }
        Collections.sort(results);
        System.out.println(results.toString());
        System.out.println(results.get((results.size() / 2)));
        System.out.println(results.size());
        System.out.println(results.size() / 2);
        //621817987
        //621817986
    }
}

