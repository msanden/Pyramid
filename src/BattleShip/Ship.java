package BattleShip;

/**
 * Properties for Ship Class
 * --------------------------------------------------
 * row & col
 * playing grid (10 by 10 grid, 0-9)
 * cells occupied by ship, empty cells are the sea
 * ---------------------------------------------------
 * Truthy if ship placed horizontally, falsy otherwise
 * ---------------------------------------------------
 * Array of booleans to return if ship is hit,
 * only battleship will use all four locations
 * ----------------------------------------------------
 * */

public abstract class Ship {

    int row;
    int col;
    int length;
    boolean horizontal;
    boolean[] hit = {false, false, false, false};

    /* Getters */
    int getRow() {
        return row;
    }

    int getCol() {
        return col;
    }

    /* Setters */
    void setRow(int row) {
        this.row = row;
    }

    void setCol(int col) {
        this.col = col;
    }

    void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    /* Helpers */
    abstract int getLength();  //Returns length of a given ship

    abstract String getShipType(); //Returns type of a given ship

    boolean isHorizontal() {
        return horizontal;
    }

    /**
     * check for legal ship placement
     *  ----constraints-----
     * must be bound in the grid range (0-9)
     * cannot overlap horizontally, diagonally, vertically
     * */
    boolean isShipPlacementOk(int row, int column, boolean horizontal, Sea sea) {
        if (horizontal) {
            if (column + getLength() > 10) {
                return false;
            }
            for (int column1 = column - 1; column1 <= column + getLength(); column++) {
                if (sea.isOccupied(row - 1, column1) || sea.isOccupied(row, column1) || sea.isOccupied(row + 1, column1)) {
                    return false;
                }
            }
            return true;
        } else {
            if (row + getLength() > 10) {
                return false;
            }
            for (int row1 = row - 1; row1 <= row + getLength(); row1++) {
                if (sea.isOccupied(row1, column - 1) || sea.isOccupied(row1, column) || sea.isOccupied(row1, column + 1)) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Place ships in sea
     * ------------------
     * We give values to row, col and horizontal instance variables for a ship
     * Provide a reference to the ship in each of 1 to 4 locations in the ship's array in the sea object
     * row, col -> int 0-9
     * horizontal -> bool
     * sea -> Object
     * */

    void placeShipAt(int row, int column, boolean horizontal, Sea sea) {
        setRow(row);
        setCol(column);
        setHorizontal(horizontal);
        Ship[][] ships = sea.getShipsArray();
        if (horizontal) {
            for (int i = column; i < column + getLength(); i++) {
                ships[row][i] = this;
            }
        }else {
            for (int i = row; i < row + getLength(); i++) {
                ships[i][column] = this;
            }
        }
    }

    /** if ship is hit but not sunk -> mark it as hit in hit array and return true. o/w false
     * */
    boolean shotAt(int row, int column) {
        if (!this.isSunk()) {
            if (this.horizontal) {
                hit[column - this.col] = true;
            } else {
                hit[row - this.row] = true;
            }
            return true;
        } else {
            return false;
        }
    }

    /* check if ship sunk */
    boolean isSunk() {
        for (int i = 0; i < getLength(); i++) {
            if (this.hit[i] == false) {
                return false;
            }
        }
        return true;
    }

  /** To use in Sea's print method
   * 'X' -> hit ship
   * 'M' -> sea
   * */
  public String toString() {
      if (this.isSunk()){
          return "x";
      } else {
          return "S";
      }
  }
}
