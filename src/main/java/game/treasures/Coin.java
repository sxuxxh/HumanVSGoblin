package game.treasures;

public class Coin extends Drop {
    // Fields
    private String weight;
    private String purity;

    // Constructors
    public Coin() {
    }

    public Coin(String name, String weight, String purity) {
        super(name);
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
                "weight='" + weight + '\'' +
                ", purity='" + purity + '\'' +
                '}';
    }
}