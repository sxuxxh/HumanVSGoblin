package game.treasures;

public class BronzeBolt extends Drop{
    // Fields
    private String size;
    private String shape;

    // Constructors
    public BronzeBolt() {
    }

    public BronzeBolt(String name, String size, String shape) {
        super(name);
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
                "size='" + size + '\'' +
                ", shape='" + shape + '\'' +
                '}';
    }
}
