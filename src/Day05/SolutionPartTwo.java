package Day05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class SolutionPartTwo {
    public static void main(String[] args) throws IOException, URISyntaxException {
        long start = System.nanoTime();
        boolean test = false;
        Path path;
        if (test) {
            path = Paths.get("src/Day05/testInput.txt");
        } else {
            path = Paths.get("src/Day05/input.txt");
        }

        File input = new File(path.toUri());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));

        String line;
        List<String> rows = new ArrayList<>();
        Map<Integer, Stack> crateStacks = new TreeMap<>();

        while ((line = bufferedReader.readLine()) != null && !line.contains("1")) {
            rows.add(line);
        }

        for (int i = 1; i < rows.get(rows.size()-1).length(); i += 4) {
            Stack<Character> stack = new Stack<>();
            for (int k = rows.size() - 1; k >= 0; k--) {
                if (rows.get(k).length()-1 >= i && Character.toString(rows.get(k).charAt(i)).matches("[A-Z]")) {
                    stack.add(rows.get(k).charAt(i));
                } else {
                    break;
                }

            }
            crateStacks.put(i, stack);
        }
        bufferedReader.readLine();

        while ((line = bufferedReader.readLine()) != null) {
            line = line.replaceAll("move", "");
            line = line.replaceAll("from", ",");
            line = line.replaceAll("to", ",");
            line = line.replaceAll("\\s", "");

            String[] string = line.replaceAll("\\[", "")
                    .replaceAll("]", "")
                    .split(",");

            int[] arr = new int[string.length];

            for (int i = 0; i < string.length; i++) {
                arr[i] = Integer.valueOf(string[i]);
            }

            int numberOfMoves = arr[0];
            int crateToMove = arr[1]*4 - 3;
            int crateDestination = arr[2]*4 - 3;
            Stack tempStack = new Stack<>();
            for (int i = 0; i < numberOfMoves; i++) {
                tempStack.add(crateStacks.get(crateToMove).pop());
            }
            for (int i = 0; i < numberOfMoves; i++) {
                crateStacks.get(crateDestination).add(tempStack.pop());
            }
        }

        StringBuilder result = new StringBuilder();

        for (Stack stack : crateStacks.values()) {
            result.append(stack.pop());
        }

        long finish = System.nanoTime();
        System.out.println((finish-start)/Math.pow(10,9) + " seconds");
        System.out.println(result);
    }

}
