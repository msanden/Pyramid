package BattleShip;

import java.util.Scanner;

public class PlayBattleShip {

    public static void main(String[] args) {

        PlayBattleShip newGame = new PlayBattleShip();

        while (newGame.runGame()) {
            continue;
        }
    }

    /**
     * runGame() sets up game env, accepts shots from user,
     * displays results, prints final score, asks if user wants
     * to play again
     * true -> "y" , false o.w
     * */
    public boolean runGame() {
        Sea sea = new Sea();
        sea.placeAllShipsRandomly();
        Scanner stdin = new Scanner(System.in);
        sea.print();

        while (!sea.isGameOver()) {
            System.out.println(
                    "Please enter two integers between 0 and 9, inclusive," +
                            " one per line"
            );
            int x = getNextInt(stdin);
            int y = getNextInt(stdin);
            if (sea.shotAt(x, y)) {
                System.out.println("hit");
                Ship[][] ships = sea.getShipsArray();
                if (ships[x][y].isSunk()) {
                    System.out.println("You sank a " + ships[x][y].getShipType() + ".");
                }
            } else {
                System.out.println("miss");
            }
            sea.print();
        }
        System.out.println("You scored a " + sea.getShotsFired() + ".");
        System.out.println("Would you like to play again?");
        String playAgain = stdin.nextLine();
        return playAgain.toLowerCase().startsWith("y");
    }

    /* Illegal inputs */
    int getNextInt(Scanner stdin) {
        int x;
        while (true) {
            try {
                x = stdin.nextInt();
                if (!isLegalNumber(x)) {
                    System.out.println("Both integers should be between 0 and 9, inclusive.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("Please enter an integer to continue.");
                stdin.nextLine();
            }
        }
        return x;
    }

    boolean isLegalNumber(int x) {
        if (x >= 0 && x <= 9) {
            return true;
        } else {
            return false;
        }
    }
}
