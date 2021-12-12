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

        ArrayList<String> paths = new ArrayList<String>(nodes.get("start").stream().toList());
        ArrayList<String> deadEnds = new ArrayList<String>();

        String currentThread = "start";
        String currentNode = "start";


        for (int i = 0; i < paths.size(); i++) {
            String path = paths.get(i);
            String pathEnding = path.substring(path.length() - 2, path.length());
            System.out.println(pathEnding);
            for (int j = 0; j < nodes.get(pathEnding).size(); j++) {

            }
        }
        for (int i = 0; i < nodes.get(currentNode).size(); i++) {
            currentNode = nodes.get(currentNode).get(i);
            for (String path : paths
            ) {
                path += currentNode;
            }

            System.out.println(currentNode);
        }
        return 0;
    }


}
