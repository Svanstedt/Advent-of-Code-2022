package Day04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException, URISyntaxException {
        long start = System.nanoTime();
        boolean test = false;
        Path path;
        if (test) {
            path = Paths.get("src/Day04/testInput.txt");
        } else {
            path = Paths.get("src/Day04/input.txt");
        }

        File input = new File(path.toUri());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));


        int fullyContainedPairs = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] array = line.split("[,-]");
            if (Integer.parseInt(array[0]) <= Integer.parseInt(array[2]) && Integer.parseInt(array[1]) >= Integer.parseInt(array[3])
            || Integer.parseInt(array[0]) >= Integer.parseInt(array[2]) && Integer.parseInt(array[1]) <= Integer.parseInt(array[3])) {
                fullyContainedPairs += 1;
            }
        }

        long finish = System.nanoTime();
        System.out.println((finish-start)/Math.pow(10,9) + " seconds");
        System.out.println(fullyContainedPairs);;
    }

}
