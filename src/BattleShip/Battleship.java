package BattleShip;

public class Battleship extends Ship {

    int length = 4;

    @Override
    String getShipType() {
        return "battleship";
    }

    @Override
    int getLength() {
        return length;
    }

}
