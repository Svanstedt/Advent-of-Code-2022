package Day06;

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
        boolean test = false;
        Path path;
        if (test) {
            path = Paths.get("src/Day06/testInput.txt");
        } else {
            path = Paths.get("src/Day06/input.txt");
        }

        File input = new File(path.toUri());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));

        String line =  bufferedReader.readLine();
        for (int i = 0; i < line.length(); i++) {
            Set<Character> characterSet = new HashSet<>();
            for (int j = i; j < i + 4; j++) {
                characterSet.add(line.charAt(j));
            }
            if (characterSet.size() == 4) {
                System.out.println(i+4);
                long finish = System.nanoTime();
                System.out.println((finish-start)/Math.pow(10,9) + " seconds");
                break;
            }
        }
    }

}