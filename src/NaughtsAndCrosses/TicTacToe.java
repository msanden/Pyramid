package NaughtsAndCrosses;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    /** steps
     * 1. print a board -> 2D array of chars
     * 2. take user input
     * 3. set up computer as opponent -> pick random spot btn 1-9
     * 4. check if the game is over
     * */

    public static void main(String[] args) {

        char[][] board = {
                {' ',' ',' '},
                {' ',' ',' '},
                {' ',' ',' '}
        };

        System.out.println("Welcome to Tic-Tac-Toe");

        Scanner scanner = new Scanner(System.in);

        printBoard(board);

        while (true) {
            userMove(board, scanner);
            if ( isGameOver(board) ) {
                break;
            };
            printBoard(board);
            computerMove(board);
            if ( isGameOver(board) ) {
                break;
            };
            printBoard(board);
        }
        scanner.close();
    }

    // check for a winner, a tie
    public static boolean isGameOver(char[][] board){
        //a winner
        if ( checkWinner(board, 'X') ) {
            printBoard(board);
            System.out.println("Player Wins!");
            return true;
        }
        if ( checkWinner(board, 'O') ) {
            printBoard(board);
            System.out.println("Computer Wins!");
            return true;
        }

        //a tie: loop through 2D array to check if board full
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("It's a tie!");
        return false;
    }

    public static boolean checkWinner(char[][] board,char sym) {
        if ((board[0][0] == sym && board[0][1] == sym && board[0][2] == sym) ||
                (board[1][0] == sym && board[1][1] == sym && board[1][2] == sym) ||
                (board[2][0] == sym && board[2][1] == sym && board[2][2] == sym) ||

                (board[0][0] == sym && board[1][0] == sym && board[2][0] == sym) ||
                (board[0][1] == sym && board[1][1] == sym && board[2][1] == sym) ||
                (board[0][2] == sym && board[1][2] == sym && board[2][2] == sym) ||

                (board[0][0] == sym && board[1][1] == sym && board[2][2] == sym) ||
                (board[0][2] == sym && board[1][1] == sym && board[2][0] == sym)) {
            return true;
        }
        return false;
    }

    private static void computerMove(char[][] board){
        Random random = new Random();
        int computerMove ;
        while(true) {
            computerMove = random.nextInt(9) + 1;
            if ( validMove(board,Integer.toString(computerMove)) ) {
                break;
            }
        }
        System.out.println("Computer chose " + computerMove);
        placeMove(board, Integer.toString(computerMove),'O');
    }


    private static boolean validMove(char[][] board, String position) {
        switch (position) {
            case "1":
                return (board[0][0] == ' ');
            case "2":
                return (board[0][1] == ' ');
            case "3":
                return (board[0][2] == ' ');
            case "4":
                return (board[1][0] == ' ');
            case "5":
                return (board[1][1] == ' ');
            case "6":
                return (board[1][2] == ' ');
            case "7":
                return (board[2][0] == ' ');
            case "8":
                return (board[2][1] == ' ');
            case "9":
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    // take and put user or computer input in right spot
    public static void userMove(char[][] board, Scanner scanner) {
        String usrInput;
        while(true) {
            System.out.println("What is your next move? (1-9)");
            usrInput = scanner.nextLine();
            if ( validMove(board, usrInput) ) {
                break;
            } else
                System.out.println("Your input " + usrInput +" is invalid");
        }
        placeMove(board, usrInput, 'X');
    }

    public static void placeMove(char[][] board, String boardPosition, char sym) {
        switch (boardPosition) {
            case "1" -> board[0][0] = sym;
            case "2" -> board[0][1] = sym;
            case "3" -> board[0][2] = sym;
            case "4" -> board[1][0] = sym;
            case "5" -> board[1][1] = sym;
            case "6" -> board[1][2] = sym;
            case "7" -> board[2][0] = sym;
            case "8" -> board[2][1] = sym;
            case "9" -> board[2][2] = sym;
            default -> System.out.println("Try again");
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
        System.out.println("-----");
        System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
        System.out.println("-----");
        System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
    }

}
