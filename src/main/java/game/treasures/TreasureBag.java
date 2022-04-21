package game.treasures;
import game.treasures.GoblinHolding;

import java.util.ArrayList;

public class TreasureBag {
    // Fields
    private ArrayList<Drop> drops;

    // Constructors
    public TreasureBag() {
    }

    public TreasureBag(ArrayList<Drop> drops) {
        this.drops = drops;
    }

    // Setters
    public void setDrops(ArrayList<Drop> drops) {
        this.drops = drops;
    }

    // Getters
    public ArrayList<Drop> getDrops() {
        return drops;
    }

    // ToString
    @Override
    public String toString() {
        return "TreasureBag{" +
                "drops=" + drops +
                '}';
    }

    // Method: add a drop
    public void addADrop() {

    }
}
