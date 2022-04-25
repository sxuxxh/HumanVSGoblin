/*
  FSE Cohort - Project6
  Human VS Goblin
  Class: BronzeBolt - child class from Drop, one of a kind dropped by Goblin
 */
package game.goodies;

public class BronzeBolt extends Drop{
    // Fields
    private String size;
    private String shape;

    // Constructors
    public BronzeBolt() {
    }

    public BronzeBolt(String name, Scarcity scarcity, String size, String shape) {
        super(name, scarcity);
        this.size = size;
        this.shape = shape;
    }

    // Setters
    public void setSize(String size) {
        this.size = size;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    // Getters
    public String getSize() {
        return size;
    }

    public String getShape() {
        return shape;
    }

    // ToString
    @Override
    public String toString() {
        return "BronzeBolt{" +
                "name='" + super.getName() + '\'' +
                ", scarcity='" + super.getScarcity() + '\'' +
                ", size='" + size + '\'' +
                ", shape='" + shape + '\'' +
                '}';
    }
}
