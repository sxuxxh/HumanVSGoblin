/*
  FSE Cohort - Project6
  Human VS Goblin
  Class: Coin - child class from Drop, one of a kind (gold and silver coins) dropped by Goblin
 */
package game.goodies;

public class Coin extends Drop {
    // Fields
    private String weight;
    private String purity;

    // Constructors
    public Coin() {
    }

    public Coin(String name, Scarcity scarcity, String weight, String purity) {
        super(name, scarcity);
        this.weight = weight;
        this.purity = purity;
    }

    // Setters
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public void setPurity(String purity) {
        this.purity = purity;
    }

    // Getters
    public String getWeight() {
        return weight;
    }

    public String getPurity() {
        return purity;
    }

    // ToString
    @Override
    public String toString() {
        return "Coin{" +
                "name='" + super.getName() + '\'' +
                ", scarcity='" + super.getScarcity() + '\'' +
                ", weight='" + weight + '\'' +
                ", purity='" + purity + '\'' +
                '}';
    }
}