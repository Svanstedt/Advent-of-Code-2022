package Day01;
import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    public static void main(String[] args) throws IOException, URISyntaxException {
        long start = System.nanoTime();
        boolean test = false;
        Path path;
        if (test) {
            path = Paths.get("src/Day01/testInput.txt");
        } else {
            path = Paths.get("src/Day01/input.txt");
        }
        File input = new File(path.toUri());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));

        int[] maxCalories = new int[3];
        String line;
        int tempMax = 0;

        while ((line = bufferedReader.readLine()) != null) {
            if (line.equals("")) {
                updateMaxCalories(maxCalories, tempMax);
                tempMax = 0;
                continue;
            }
            tempMax += Integer.parseInt(line);
        }
        updateMaxCalories(maxCalories, tempMax);
        int total = 0;
        for (int i = 0; i < maxCalories.length; i++) {
            total += maxCalories[i];
        }
        System.out.println("Max: " + maxCalories[0]);
        System.out.println("Top 3: " + total);
        long finish = System.nanoTime();
        System.out.println((finish-start)/Math.pow(10,9) + " seconds");

    }

    private static void updateMaxCalories(int[] maxCalories, int tempMax) {
        for (int i = 0; i < maxCalories.length; i++) {
            if (tempMax > maxCalories[i]) {
                for (int j = maxCalories.length-1; j > i; j--) {
                    maxCalories[j] = maxCalories[j-1];
                }
                maxCalories[i] = tempMax;
                break;
            }
        }
    }
}
