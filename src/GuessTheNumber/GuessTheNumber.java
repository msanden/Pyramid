package GuessTheNumber;/*
* Manuel S. Nyagisere
* GuessTheNumber.java
*
* */

import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {

        // Generate random number between 1-20
        int min = 1, max = 20;
        int randNum =  (int)(Math.random()*(max-min+1)+min);

        int counter = 0;
        int input;

        // Get user's name
        System.out.println("Hello! What is your name?");
        Scanner stdin = new Scanner(System.in);
        String name = stdin.nextLine();
        System.out.println("Well, "+ name +", I am thinking of a number between 1 and 20.\n" +
                "Take a guess.");
        do {
            // Get user's guessed integer
            input = stdin.nextInt();

            //
            if (input > randNum) {
                System.out.println("Your guess is too high.\n" + "Take a guess.");
                counter++;
            } else if (input < randNum) {
                System.out.println("Your guess is too low.\n" + "Take a guess.");
                counter++;
            } else
                System.out.println("Good job, "+name+"! You guessed my number in "+ counter +" guesses!\n" +
                        "Would you like to play again? (y or n)");
        } while (input != randNum);

    }
}

