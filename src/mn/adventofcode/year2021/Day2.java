package mn.adventofcode.year2021;

public class Day2 {
    public static int getResult() {
        String input = HelperMethods.readInputString(2);
        String[] array = input.split((" "));
        int distance = 0;
        String command = "";
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        for (int i = 0; i < array.length; i += 2) {
            command = array[i];
            distance = Integer.valueOf(array[i + 1]);
            switch (command) {
                case "forward":
                    horizontal += distance;
                    depth += distance * aim;
                    break;
                case "up":
                    aim -= distance;
                    break;
                case "down":
                    aim += distance;
                    break;

            }
        }
        return depth * horizontal;
    }
}
