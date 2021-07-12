package BattleShip;

import java.util.Random;

/**
 * Sea Class properties
 * --------------------
 * Ships array to determine ship location
 * Fired array to determine if location has been hit
 * int to count number of shots fired
 * int to count number of hits made. Repeat hits counted but insignificant to gameplay
 * */

public class Sea {

    Ship[][] ships = new Ship[10][10];
    boolean[][] fired = new boolean[10][10];
    int shotsFired;
    int hitsCount;

    public Sea() {
        this.shotsFired = 0;
        this.hitsCount = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                ships[i][j] = new EmptySea();
                fired[i][j] = false;
            }
        }
    }

    /* Legally place all 10 ships randomly in initially empty sea */
    void placeAllShipsRandomly() {
        Ship[] myFleet = {
                new Battleship(),
                new Cruiser(),
                new Cruiser(),
                new Destroyer(),
                new Destroyer(),
                new Destroyer(),
                new Submarine(),
                new Submarine(),
                new Submarine(),
                new Submarine(),
        };
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Ship ship = myFleet[i];
            while (true) {
                int x = random.nextInt(10);
                int y = random.nextInt(10);
                boolean horizontal = random.nextInt(2) == 0;
                if (ship.isShipPlacementOk(x, y, horizontal, this)) {
                    ship.placeShipAt(x, y, horizontal, this);
                    break;
                }
            }
        }
    }

    /*Check if location occupied by ship*/
    boolean isOccupied(int row, int column) {
        if (row < 0 || row > 9 || column < 0 || column > 9) {
            return false;
        }
        if (ships[row][column] instanceof EmptySea) {
            return false;
        }
        return true;
    }

    /** Truthy for not a miss, ship not sunk and falsy o.w
     * Also updates count of shots fired and number of hits
     * */
    boolean shotAt(int row, int column) {
        fired[row][column] = true;
        shotsFired++;
        if (ships[row][column].shotAt(row, column)) {
            hitsCount++;
            return true;
        } else {
            return false;
        }
    }

    /* Get number of shot attempts */
    int getShotsFired() {
        return shotsFired;
    }

    /* Get number of hit attempts */
    int getHitsCount() {
        return hitsCount;
    }

    /* Check if game is over */
    boolean isGameOver() {
        int count = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (ships[i][j].isSunk()) {
                    count++;
                }
            }
        }
        return count == 20;
    }

    /* Return grid of ships */
    Ship[][] getShipsArray() {
        return ships;
    }

    /** Print Sea grid.
     * row and col numbers displayed along edges
     * 'S' -> hit a ship
     * 'M' -> a miss
     * '.' -> location never fired upon
     * 'x' -> sunken ship
     * */
    void print() {
        System.out.println("    0 1 2 3 4 5 6 7 8 9");
        System.out.println("   ----------------------");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " |");
            for (int j = 0; j < 10; j++) {
                if (!fired[i][j]) {
                    System.out.print(" .");
                } else {
                    System.out.print(" " + ships[i][j].toString());
                }
            }
            System.out.println();
        }
    }
}
