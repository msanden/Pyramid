package Hangman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {

        // random word array
        String[] words = {
                "notorious", "difficult", "hangman", "dozen",
                "explicit", "implicit", "soccer", "kangaroo",
                "milk","refrigerator"
        };

        // select random word
        String hiddenWord = words[(int) (Math.random() * words.length)];
        System.out.println(hiddenWord);
        List<Character> userGuesses = new ArrayList<>();
        System.out.println("WELCOME TO HANGMAN");
        Scanner userInput = new Scanner(System.in);

        int incorrectGuess = 0;

        while(true) {

            printHangman(incorrectGuess);
            if (incorrectGuess >= 6) {
                System.out.println("You are out of guesses. Try again");
                break;
            }

            if (!getPlayerGuess(userInput, hiddenWord, userGuesses)){
                incorrectGuess++;
            }

            if (playGame(hiddenWord, userGuesses)) {
                System.out.println("Yes! The secret word is " + hiddenWord + "! You have won!");
                break;
            }
        }

    }

    static void printHangman(Integer incorrectGuess){
        System.out.println("-------");
        System.out.println("   |   ");

        if (incorrectGuess >= 1) {
            System.out.println("   0   ");
        }

        if (incorrectGuess >=2) {
            System.out.print("  /");
            if (incorrectGuess >=3) {
                System.out.println(" \\");
            } else
                System.out.println("");
        }

        if (incorrectGuess >= 4) {
            System.out.println("   |   ");
        }

        if (incorrectGuess >= 5) {
            System.out.print("  /");
            if (incorrectGuess >= 6) {
                System.out.println(" \\");
            } else
                System.out.println("");
        }
    }

    static boolean getPlayerGuess(Scanner userInput, String hiddenWord, List<Character> userGuesses) {
        System.out.println("Guess a letter");
        String letterGuess = userInput.nextLine();
        userGuesses.add(letterGuess.charAt(0));
        return hiddenWord.contains(letterGuess);
    }

    static boolean playGame (String hiddenWord, List<Character> userGuesses) {
        int count = 0;
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (userGuesses.contains(hiddenWord.charAt(i))) {
                System.out.print(hiddenWord.charAt(i));
                count++;
            } else
                System.out.print("_");
        }
        System.out.println();
        return (hiddenWord.length() == count);
    }


}
