package mn.adventofcode.year2021;

import jdk.swing.interop.SwingInterOpUtils;
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


        //Nodes = listarray
        //get nodes connected to start add to paths(must be array and not listarray)
        //for nodes connected to start
        //check if node is "end" if so add to completed paths can be listArray
        //Check if node connected to start == lowercase or "start"
        //if not add to paths
        //nodes = nodes
        ArrayList<String> endings = new ArrayList<>();
        ArrayList<String> paths = new ArrayList<>();
        paths.add("start");
        for (int i = 0; i < paths.size(); i++) {
            String currentPath = paths.get(i);
            ArrayList<String> currentNode;
            if (paths.get(i).equals("start")) {
                currentNode = nodes.get("start");
            } else {
                currentNode = nodes.get(currentPath.substring(currentPath.length() - 2));
            }
            for (int j = 0; j < currentNode.size(); j++) {
                String currentEnding = currentNode.get(j);
                if (Character.isLowerCase(currentEnding.charAt(0))) {
                    if (currentEnding.equals("end")) {
                        endings.add(currentPath + currentEnding);
                    }
                    else if (currentEnding.contains("tart")) {

                    }
                    else if (currentPath.contains(currentEnding)) {
                        if(currentPath.charAt(0)=='X') {
                        } else {
                            paths.add("X"+currentPath.substring(1) + currentEnding);
                        }

                    } else {
                        paths.add(currentPath + currentEnding);
                    }

                } else {
                    paths.add(currentPath + currentEnding);
                }

            }
            int pathsCounter = 1;
            int newlyAdded = 1;

        }
        return endings.size();
    }
}
