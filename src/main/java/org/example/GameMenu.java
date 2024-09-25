package org.example;

import java.util.Locale;
import java.util.Scanner;

public class GameMenu {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            Menu();
        }
    }

    public static char readChoice(){
        return scan.nextLine().toUpperCase(Locale.ROOT).charAt(0);
    }

    public static void Menu(){
        System.out.println("1.Начать игру\n"+
                "2.Выход из игры\n");
        int choice = readChoice();
        switch (choice) {
            case '1':
                System.out.println("Game started");
                GameProcess.startGame();
                break;
            case '2':
                System.out.println("Exit...");
                System.exit(0);
                break;
            default:
                System.out.println("Input valid value");
                break;
        }
    }
}