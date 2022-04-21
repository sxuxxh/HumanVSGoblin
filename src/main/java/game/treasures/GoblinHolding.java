package game.treasures;

import java.util.ArrayList;
import java.util.HashMap;
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
        ArrayList<Drop> dropLst = new ArrayList<>();
        Coin goldCoin = new Coin("Gold Coin","1oz","24K");
        Coin silverCoin = new Coin("Silver Coin","1oz","99.9");
        ChefHat chefHat1 = new ChefHat("Magic Hat","round","white");
        ChefHat chefHat2 = new ChefHat("Tall Hat","pointy","black");
        BronzeBolt bronzeBolt1 = new BronzeBolt("BigBolt","4-in","hex");
        BronzeBolt bronzeBolt2 = new BronzeBolt("LongBolt","8-in","round");
        MindRune mindRune1 = new MindRune("Kicker",50,"EastAsia");
        MindRune mindRune2 = new MindRune("Roller",85,"SouthAmerica");
        dropLst.add(goldCoin);
        dropLst.add(silverCoin);
        dropLst.add(chefHat1);
        dropLst.add(chefHat2);
        dropLst.add(bronzeBolt1);
        dropLst.add(bronzeBolt2);
        dropLst.add(mindRune1);
        dropLst.add(mindRune2);
        for (int i=0; i< dropLst.size(); i++) {
            this.goblinHoldings.put(i,dropLst.get(i));
        }
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
    private int getRandomInt() {
        return ThreadLocalRandom.current().nextInt(0, 7);
    }
}
