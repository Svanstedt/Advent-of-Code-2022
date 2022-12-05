package Day05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException, URISyntaxException {
        long start = System.nanoTime();
        boolean test = true;
        Path path;
        if (test) {
            path = Paths.get("src/Day05/testInput.txt");
        } else {
            path = Paths.get("src/Day05/input.txt");
        }

        File input = new File(path.toUri());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));

        String line;
        List<String> stacks = new ArrayList<>();
        Map<Integer, Stack> crateStacks = new HashMap<>();

        while ((line = bufferedReader.readLine()) != null && !line.contains("1")) {
            stacks.add(line);
        }

        for (int i = 1; i < stacks.get(stacks.size()-1).length(); i += 4) {
            Stack<Character> stack = new Stack<>();
            for (int k = stacks.size() - 1; k >= 0; k--) {
                if ((stacks.get(k).charAt(i) + "").matches("[A-Z]")) {
                    stack.add(stacks.get(k).charAt(i));
                } else {
                    break;
                }

            }
            crateStacks.put(i, stack);
        }






        long finish = System.nanoTime();
        System.out.println((finish-start)/Math.pow(10,9) + " seconds");
    }

}
