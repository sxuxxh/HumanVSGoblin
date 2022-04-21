package game.treasures;

public class Drop {
    // Fields
    private String name;
    private enum scarcity {HIGH, MEDIUM, LOW};

    // Constructors
    public Drop() {
    }

    public Drop(String name) {
        this.name = name;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    // Getters
    public String getName() {
        return name;
    }

    // ToString
    @Override
    public String toString() {
        return "Drop{" +
                "name='" + name + '\'' +
                '}';
    }
}

