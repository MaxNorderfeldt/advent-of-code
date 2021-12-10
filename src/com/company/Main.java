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
            File myObj = new File("C:\\Temp\\inputDay10.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNext()) {
                input.add(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        ArrayList<Character> brackets = new ArrayList<Character>();

        ArrayList<Character> syntaxErrors = new ArrayList<Character>();
        char currentChar = ' ';
        int sum=0;
        for (String line : input) {
            outer:
            for (int i = 0; i < line.length(); i++) {
                currentChar = line.charAt(i);
                if(currentChar==')') {
                    if(brackets.get(brackets.size()-1)=='(') {
                        brackets.remove(brackets.size()-1);
                    } else {
                        syntaxErrors.add(currentChar);
                        sum+=3;
                        break outer;
                    }
                } else if(currentChar=='}') {
                    if(brackets.get(brackets.size()-1)=='{') {
                        brackets.remove(brackets.size()-1);
                    } else {
                        syntaxErrors.add(currentChar);
                        sum+=1197;
                        break outer;
                    }
                }else if(currentChar=='>') {
                    if(brackets.get(brackets.size()-1)=='<') {
                        brackets.remove(brackets.size()-1);
                    } else {
                        syntaxErrors.add(currentChar);
                        sum+=25137;
                        break outer;
                    }
                }else if(currentChar==']') {
                    if(brackets.get(brackets.size()-1)=='[') {
                        brackets.remove(brackets.size()-1);
                    } else {
                        syntaxErrors.add(currentChar);
                        sum+=57;
                        break outer;
                    }
                }else {
                    brackets.add(currentChar);

                }
            }
            for (int i = brackets.size()-1; i>=0; i--) {
                line
            }
        }

        System.out.println(syntaxErrors.size());
        System.out.println(sum);
    }
}

