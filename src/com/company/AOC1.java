package com.company;

import java.util.ArrayList;
import java.util.List;

public class AOC1 {

    public static int AOC1(int[] input) {
        List<Integer> blocks = new ArrayList<>();
        for (int i = 1; i < input.length-1; i++) {
            int block = input[i-1]+input[i]+input[i+1];
            blocks.add(block);
        }
        int counter=0;
        for (int i = 1; i < blocks.size(); i++) {
            if(blocks.get(i)> blocks.get(i-1)) {
                counter++;
            }
        }
        return counter;
    }
}
