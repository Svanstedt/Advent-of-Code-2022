package Day02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException, URISyntaxException {
        long start = System.nanoTime();
        boolean test = false;
        Path path;
        if (test) {
            path = Paths.get("src/Day02/testInput.txt");
        } else {
            path = Paths.get("src/Day02/input.txt");
        }

        File input = new File(path.toUri());
        BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
        BufferedReader secondBufferedReader = new BufferedReader(new FileReader(input));

        String[] wins = {"A Y", "B Z", "C X"};
        String[] draws = {"A X", "B Y", "C Z"};

        Map<String, Integer> choicePoints = new HashMap<String, Integer>();
        choicePoints.put("X", 1);
        choicePoints.put("Y", 2);
        choicePoints.put("Z", 3);


        int points = 0;
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (Arrays.asList(wins).contains(line)) {
                points += 6;
            } else if (Arrays.asList(draws).contains(line)) {
                points += 3;
            }
            points += choicePoints.get(line.substring(line.length() - 1));
        }

        Map<String, String> loseMap = new HashMap<String, String>();
        loseMap.put("A", "Z");
        loseMap.put("B", "X");
        loseMap.put("C", "Y");

        Map<String, String> winMap = new HashMap<String, String>();
        winMap.put("A", "Y");
        winMap.put("B", "Z");
        winMap.put("C", "X");

        Map<String, String> drawMap = new HashMap<String, String>();
        drawMap.put("A", "X");
        drawMap.put("B", "Y");
        drawMap.put("C", "Z");

        int pointsTwo = 0;
        while ((line = secondBufferedReader.readLine()) != null) {
            String lastChar = line.substring(line.length() - 1);
            String firstLetter = String.valueOf(line.charAt(0));
            String choice;
            if (lastChar.equals("X")) {
                choice = loseMap.get(firstLetter);
            } else if (lastChar.equals("Y")) {
                choice = drawMap.get(firstLetter);
                pointsTwo += 3;
            } else {
                choice = winMap.get(firstLetter);
                pointsTwo += 6;
            }
            pointsTwo += choicePoints.get(choice);
        }

        long finish = System.nanoTime();
        System.out.println((finish-start)/Math.pow(10,9) + " seconds");
        System.out.println(points);
        System.out.println(pointsTwo);
    }

}
