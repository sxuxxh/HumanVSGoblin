/*
  FSE Cohort - Project6
  Human VS Goblin
  Class: GoodyBag - defines collection of goodies the human player obtains from Goblin
 */
package game.goodies;
import game.HumanVSGoblin;

import java.util.ArrayList;

public class GoodyBag {
    // Fields
    private ArrayList<Drop> drops;

    // Constructors
    public GoodyBag() {
    }

    public GoodyBag(ArrayList<Drop> drops) {
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
        this.drops.add(HumanVSGoblin.goblinHolding.makeADrop());
    }

    // Method: show my treasure
    public void showGoody() {
        String showGoody = "Taking a peek inside your goody bag...                        ";
        HumanVSGoblin.infoPanel.updateInfoPanel(showGoody);
        if (this.getDrops().size()==0) {
            HumanVSGoblin.infoPanel.updateInfoPanel("> Oops, goody bag is empty. You got this!    ");
        } else {
            for (Drop drop : this.getDrops()) {
                showGoody = "* ";
                if (drop instanceof Coin) {
                    showGoody += drop.getName() + ", Scarcity=" + drop.getScarcity() + ", Purity=" + ((Coin) drop).getPurity() + ", Weight=" + ((Coin) drop).getWeight();
                }
                if (drop instanceof ChefHat) {
                    showGoody += drop.getName() + ", Scarcity=" + drop.getScarcity() + ", Style=" + ((ChefHat) drop).getStyle() + ", Color=" + ((ChefHat) drop).getColor();
                }
                if (drop instanceof MindRune) {
                    showGoody += drop.getName() + ", Scarcity=" + drop.getScarcity() + ", Age=" + ((MindRune) drop).getAge() + "-yrs, Origin=" + ((MindRune) drop).getOrigin();
                }
                if (drop instanceof BronzeBolt) {
                    showGoody += drop.getName() + ", Scarcity=" + drop.getScarcity() + ", Shape=" + ((BronzeBolt) drop).getShape() + ", Size=" + ((BronzeBolt) drop).getSize();
                }
                HumanVSGoblin.infoPanel.updateInfoPanel(showGoody);
                showGoody = "";
            }
        }
    }

}