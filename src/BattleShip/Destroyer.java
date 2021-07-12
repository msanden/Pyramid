package BattleShip;

public class Destroyer extends Ship {

    int length = 2;

    @Override
    int getLength() {
        return length;
    }

    @Override
    String getShipType() {
        return "destroyer";
    }
}
