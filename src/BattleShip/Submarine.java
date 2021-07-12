package BattleShip;

public class Submarine extends Ship{

    int length = 1;

    @Override
    int getLength() {
        return length;
    }

    @Override
    String getShipType() {
        return "submarine";
    }
}
