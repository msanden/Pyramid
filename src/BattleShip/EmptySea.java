package BattleShip;

public class EmptySea extends Ship{

    int length = 1;

    /* return false indicating no ship was hit */
    @Override
    boolean shotAt(int row, int column) {
        return false;
    }

    /* return false indicating no ship was sunk */
    @Override
    boolean isSunk() {
        return false;
    }

    /* Single character String "M" to use in Sea print method */
    @Override
    public String toString() {
        return "M";
    }

    @Override
    int getLength() {
        return length;
    }

    @Override
    String getShipType() {
        return "sea";
    }
}
