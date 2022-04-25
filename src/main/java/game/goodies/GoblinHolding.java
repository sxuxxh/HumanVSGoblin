/*
  FSE Cohort - Project6
  Human VS Goblin
  Class: GoblinHolding - defines collection of goodies which Goblin can drop
 */
package game.goodies;

import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class GoblinHolding {
    // Fields
    private Map<Integer, Drop> goblinHoldings;

    // Constructors
    public GoblinHolding() {
    }

    public GoblinHolding(Map<Integer, Drop> goblinHoldings) {
        this.goblinHoldings = goblinHoldings;
    }

    // Setters
    public void setGoblinHoldings(Map<Integer, Drop> goblinHoldings) {
        this.goblinHoldings = goblinHoldings;
    }

    // Getters
    public Map<Integer, Drop> getGoblinHoldings() {
        return goblinHoldings;
    }

    // ToString
    @Override
    public String toString() {
        return "GoblinHolding{" +
                "goblinHoldings=" + goblinHoldings +
                '}';
    }

    // Method: populate Goblin holdings
    public void fillGoblinHolding() {
        this.goblinHoldings.put(1, new Coin("GoldCoin",Scarcity.HIGH,"1oz","24K"));
        this.goblinHoldings.put(2, new Coin("GoldCoin",Scarcity.HIGH,"2oz","18K"));
        this.goblinHoldings.put(3, new Coin("SilverCoin",Scarcity.MEDIUM,"1oz","99.9%"));
        this.goblinHoldings.put(4, new Coin("SilverCoin",Scarcity.MEDIUM,"2oz","96.9%"));
        this.goblinHoldings.put(5, new ChefHat("MagicHat",Scarcity.LOW,"round","white"));
        this.goblinHoldings.put(6, new ChefHat("TallHat",Scarcity.LOW,"pointy","black"));
        this.goblinHoldings.put(7, new BronzeBolt("BigBolt",Scarcity.LOW,"4-in","hex"));
        this.goblinHoldings.put(8, new BronzeBolt("LongBolt",Scarcity.LOW,"8-in","round"));
        this.goblinHoldings.put(9, new MindRune("S-Rune",Scarcity.MEDIUM,50,"WestEU"));
        this.goblinHoldings.put(10, new MindRune("J-Rune",Scarcity.MEDIUM,85,"EastAsia"));
    }

    // Method: make a drop
    public Drop makeADrop() {
        Drop drop = new Drop();
        int num = getRandomInt();
        for (int key: goblinHoldings.keySet()
        ) {
            drop = goblinHoldings.get(num);
        }
        return drop;
    }

    //Method: generate random number as key for a drop
    public int getRandomInt() {
        return ThreadLocalRandom.current().nextInt(1, 10);
    }
}
