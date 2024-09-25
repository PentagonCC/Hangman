package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class RandomChoiceWord {

    public static char[] getRandomWord(){
        String filePath = "C:/Users/iv-ni/OneDrive/Рабочий стол/Java/petProject/Hangman/src/main/java/org/example/words.txt";
        List<String> words = readLinesFromFile(filePath);

        Random randomizer = new Random();
        int randomWordIndex = randomizer.nextInt(words.size());
        return words.get(randomWordIndex).toUpperCase(Locale.ROOT).toCharArray();
    }

    public static List<String> readLinesFromFile(String filePath){
        List<String> lines = new ArrayList<>();
        try(BufferedReader readLine = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = readLine.readLine()) != null){
                lines.add(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }
}
