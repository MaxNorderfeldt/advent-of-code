package mn.adventofcode.year2021;

import mn.adventofcode.year2021.utilities.HelperMethods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Day14 {
    public static long getResult() {
        HashMap<String, Character> pairInsertions = new HashMap<String, Character>();

        ArrayList<String> input = HelperMethods.readInput(14);
        ArrayList<Character>[] polymerTemplate = new ArrayList[20];
        //ArrayList<Character> polymerTemplate = new ArrayList<>();
        String firstRow = input.get(0);
        for (int i = 0; i < firstRow.length(); i++) {
            polymerTemplate[i] = new ArrayList<Character>();
            polymerTemplate[i].add(firstRow.charAt(i));
        }

        for (int i = 2; i < input.size(); i++) {
            String row = input.get(i);
            String[] splitRow = row.split(" -> ");
            pairInsertions.put(splitRow[0], row.charAt(6));
        }

        int steps = 40;
        //NBBBCNCCNBBNBNBBCHBHHBCHB
        for (int step = 0; step < steps; step++) {
            System.out.println("step " + step);
            ArrayList<Character> tempPolymer = new ArrayList<>();
            for (int i = 0; i < polymerTemplate.length; i++) {
                tempPolymer = new ArrayList<>(polymerTemplate[i]);
                int addCounter=1;
                for (int j = 0; j < polymerTemplate[i].size(); j++) {

                    if (j < polymerTemplate[i].size() - 1) {
                        tempPolymer.add(addCounter,pairInsertions.get("" + polymerTemplate[i].get(j) + polymerTemplate[i].get(j + 1)));
                        addCounter+=2;
                    } else{
                    }
                }
                polymerTemplate[i] = tempPolymer;
            }
            for (int i = 0; i < polymerTemplate.length - 1 ; i++) {
                polymerTemplate[i].add(pairInsertions.get("" + polymerTemplate[i].get(polymerTemplate[i].size() - 1) + polymerTemplate[i + 1].get(0)));
            }
        }



        Set<Character> uniques = new HashSet<Character>();
        for (int i = 0; i < polymerTemplate.length; i++) {
            for (char c : polymerTemplate[i]) {
                uniques.add(c);
            }
        }

        long maxLetter = 0;
        long minLetter = Long.MAX_VALUE;
        for (char letter : uniques
        ) {
            long counter = 0;
            for (int i = 0; i < polymerTemplate.length; i++) {
                for (int j = 0; j < polymerTemplate[i].size(); j++) {
                    if (polymerTemplate[i].get(j) == letter) {
                        counter++;
                    }
                }
            }
            if (counter > maxLetter) {
                maxLetter = counter;
            }
            if (counter < minLetter) {
                minLetter = counter;
            }
        }

        System.out.println("Old: NC-NB-CH-B-0");
        System.out.println(maxLetter-minLetter);
        return 0;
    }
}
