package Day03;

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
            path = Paths.get("src/Day03/testInput.txt");
        } else {
            path = Paths.get("src/Day03/input.txt");
        }

        File input = new File(path.toUri());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));

        Map<Integer, Set<Character>> characterMap = new HashMap<>();
        Set<Character> characterSet;

        int numOfLines = 8;
        int prioritySum = 0;
        String line;
        while (bufferedReader.ready()) {
            for (int i = 0; i < numOfLines; i++) {
                line = bufferedReader.readLine();
                characterSet = new HashSet<>();
                for (int j = 0; j < line.length(); j++) {
                    characterSet.add(line.charAt(j));
                }
                characterMap.put(i, characterSet);
            }

            Set<Character> commonCharacters = characterMap.get(0);
            for (int i = 1; i < numOfLines; i++) {
                commonCharacters.retainAll(characterMap.get(i));
            }

            for (Character character : commonCharacters) {
                prioritySum += Alphabet.getNum(character);
            }
        }


        long finish = System.nanoTime();
        System.out.println((finish-start)/Math.pow(10,9) + " seconds");
        System.out.println("Priority sum: " + prioritySum);
    }

}
