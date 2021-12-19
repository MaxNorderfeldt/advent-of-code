package mn.adventofcode.year2021;

import mn.adventofcode.year2021.utilities.HelperMethods;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Day14 {
    public static long getResult() {
        HashMap<String, String> pairInsertions = new HashMap<String, String>();

        ArrayList<String> input = HelperMethods.readInput(14);
        ArrayList<Character> polymerTemplate = new ArrayList<>();

        for (char c : input.get(0).toCharArray()) {
            chars.add(c);
        }
        for (int i = 2; i < input.size(); i++) {
            String[] splitRow = input.get(i).split(" -> ");
            pairInsertions.put(splitRow[0], splitRow[1]);
        }

        int steps = 40;
        for (int step = 0; step < steps; step++) {
            System.out.println("Step" + step);
            ArrayList<String> commandsToRun=new ArrayList<>();
            for (long i = 0; i < polymerTemplate.length()-1; i++) {
                String command = polymerTemplate.substring((int)i, (int)i+2);
                commandsToRun.add(command);
            }
            polymerTemplate=;
            String command="";
            for (int i = 0; i < commandsToRun.size(); i++) {
                command = commandsToRun.get(i);
                String polymerToAdd =command.charAt(0) + pairInsertions.get(command) ;
                polymerTemplate+=polymerToAdd;
            }
            polymerTemplate+=command.charAt(1);
        }

        char characters[] = polymerTemplate.toCharArray();
        Set<Character> uniques = new HashSet<Character>();
        for (char c: characters) {
            uniques.add(c);
        }
        long maxLetter = 0;
        long minLetter = Long.MAX_VALUE;
        for (char letter : uniques
             ) {
            long counter=0;
            for (long i = 0; i < polymerTemplate.length(); i++) {
                if(polymerTemplate.charAt((int)i)==letter) {
                    counter++;
                }
            }
            if(counter>maxLetter) {
                maxLetter=counter;
            }
            if(counter<minLetter) {
                minLetter=counter;
            }
        }
        return maxLetter-minLetter;
    }
}
