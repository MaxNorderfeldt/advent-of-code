package mn.adventofcode.year2021;

import mn.adventofcode.year2021.utilities.HelperMethods;

import java.util.ArrayList;
import java.util.HashMap;

public class Day12 {
    public static int getResult() {
        ArrayList<String> input = HelperMethods.readInput(12);

        HashMap<String, ArrayList<String>> nodes = new HashMap<String, ArrayList<String>>();


        String[] tempArray = new String[2];
        for (int i = 0; i < input.size(); i++) {
            tempArray = input.get(i).split("-");
            String key = tempArray[0];
            String val = tempArray[1];
            ArrayList<String> current = nodes.get(key);
            if (current == null) {
                current = new ArrayList<String>();
                nodes.put(key, current);
            }
            current.add(val);
        }

        for (int i = 0; i < input.size(); i++) {
            tempArray = input.get(i).split("-");
            String key = tempArray[1];
            String val = tempArray[0];
            ArrayList<String> current = nodes.get(key);
            if (current == null) {
                current = new ArrayList<String>();
                nodes.put(key, current);
            }
            current.add(val);
        }

        String[] paths = new String[1000];
        int pathsIndex=0;
        for (int i = 0; i < nodes.get("start").size(); i++) {
            paths[pathsIndex]=nodes.get("start").get(i);
            pathsIndex++;
        }
        ArrayList<String> deadEnds = new ArrayList<>();
        ArrayList<String> tempPaths = new ArrayList<>();

        String currentThread = "start";
        String currentNode = "start";
        int counter=0;
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < counter; i++) {
                String path = paths[i];
                String pathEnding = path.substring(path.length() - 2, path.length());
                for (int k = 0; k < nodes.get(pathEnding).size(); k++) {
                    path+=nodes.get(pathEnding).get(k);
                }


            }

        }
        System.out.println(nodes.toString());
        System.out.println(paths.toString());
        return 0;
    }


}
