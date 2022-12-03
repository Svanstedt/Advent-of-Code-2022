package Day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class solution {
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

        String line;
        String firstHalf;
        String secondHalf;
        Set<Character> firstHalfCharacters = new HashSet<Character>();
        Set<Character> charactersInFirstAndSecondHalf = new HashSet<Character>();
        int prioritySum = 0;
        int halfIndex;
        while ((line = bufferedReader.readLine()) != null) {
            halfIndex = line.length()/2;
            firstHalf = line.substring(0, halfIndex);
            secondHalf = line.substring(halfIndex );
            for (int i = 0; i < firstHalf.length(); i++) {
                firstHalfCharacters.add(firstHalf.charAt(i));
            }

            for (int j = 0; j < secondHalf.length(); j++) {
                if (firstHalfCharacters.contains(secondHalf.charAt(j))) {
                    charactersInFirstAndSecondHalf.add(secondHalf.charAt(j));
                }
            }

            for (Character commonCharacter : charactersInFirstAndSecondHalf) {
                prioritySum += Alphabet.getNum(commonCharacter);
            }
            firstHalfCharacters.clear();
            charactersInFirstAndSecondHalf.clear();
        }


        long finish = System.nanoTime();
        System.out.println((finish-start)/Math.pow(10,9) + " seconds");
        System.out.println("Priority sum: " + prioritySum);
    }

}
