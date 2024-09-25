package org.example;

import java.util.*;

public class GameProcess {

    static final int MAX_ERROR = 6;
    static List<Character> inputErrorLetter;
    static int errorCounter;
    static char[] secretWord;
    static char[] secretWordView;
    static GameCondition condition;


    public static void startGame(){
        String[] conditions = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX"};
        errorCounter = 0;
        inputErrorLetter = new ArrayList<>();
        secretWord = RandomChoiceWord.getRandomWord();
        secretWordView = new char[secretWord.length];
        for(int i = 0; i < secretWord.length; i++){
            secretWordView[i] = '#';
        }
        condition = GameCondition.valueOf(conditions[errorCounter]);
        boolean gameStatus = true;

        while(gameStatus){
            System.out.println(condition);
            System.out.println(secretWord);
            System.out.println("Слово: " + Arrays.toString(secretWordView));
            System.out.println("Ошибки:("+ errorCounter+") " + inputErrorLetter);
            System.out.println("Введите букву:");
            char choiceLetter = GameMenu.readChoice();

            if(Arrays.toString(secretWord).contains(String.valueOf(choiceLetter))){
                for(int i = 0; i< secretWord.length; i++){
                    if(secretWord[i] == choiceLetter){
                        secretWordView[i] = secretWord[i];
                    }
                }
                if(!Arrays.toString(secretWordView).contains(String.valueOf('#'))){
                    gameStatus = false;
                }
            }
            else{
                if(inputErrorLetter.contains(choiceLetter)){
                    System.out.println("Вы уже вводили эту букву");
                }
                else{
                    inputErrorLetter.add(choiceLetter);
                    errorCounter++;
                }
                condition = GameCondition.valueOf(conditions[errorCounter]);
                if(errorCounter == MAX_ERROR){
                    gameStatus = false;
                }
            }
        }
        if(errorCounter != MAX_ERROR){
            System.out.println("Поздравляем, вы отгадали слово: "+ Arrays.toString(secretWord));
        }
        else{
            System.out.println(GameCondition.SIX);
            System.out.println("К сожалению вы проиграли, скрытое слово было: "+ Arrays.toString(secretWord));
        }

        GameMenu.Menu();

    }


}
