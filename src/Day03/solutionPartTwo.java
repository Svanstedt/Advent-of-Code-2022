package Day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class solutionPartTwo {
    public static void main(String[] args) throws IOException, URISyntaxException {
        long start = System.nanoTime();
        boolean test = false;
        Path path;
        if (test) {
            path = Paths.get("src/Day03/testInput.txt");
        } else {
            path = Paths.get("src/Day03/input.txt");
        }

        File input = new File(path.toUri());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));

        String line1, line2, line3;
        Set<Character> charactersInFirstLine = new HashSet<Character>();
        Set<Character> charactersInFirstAndSecondLine = new HashSet<Character>();
        Set<Character> charactersInAllLines = new HashSet<Character>();

        int prioritySum = 0;
        int halfIndex;
        while ((line1 = bufferedReader.readLine()) != null
        && (line2 = bufferedReader.readLine()) != null
        && (line3 = bufferedReader.readLine()) != null)
        {
            for (int i = 0; i < line1.length(); i++) {
                charactersInFirstLine.add(line1.charAt(i));
            }

            for (int j = 0; j < line2.length(); j++) {
                if (charactersInFirstLine.contains(line2.charAt(j))) {
                    charactersInFirstAndSecondLine.add(line2.charAt(j));
                }
            }
            charactersInFirstLine.clear();

            for (int k = 0; k < line3.length(); k++) {
                if (charactersInFirstAndSecondLine.contains(line3.charAt(k))) {
                    charactersInAllLines.add(line3.charAt(k));
                }
            }
            charactersInFirstAndSecondLine.clear();

            for (Character commonCharacter : charactersInAllLines) {
                prioritySum += Alphabet.getNum(commonCharacter);
            }
            charactersInAllLines.clear();

        }

        long finish = System.nanoTime();
        System.out.println((finish-start)/Math.pow(10,9) + " seconds");
        System.out.println("Priority sum: " + prioritySum);
    }

}
