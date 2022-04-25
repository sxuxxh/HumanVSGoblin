/*
  FSE Cohort - Project6
  Human VS Goblin
  Class: Drop - base class for all goody drops by Goblin
 */
package game.goodies;

public class Drop {
    // Fields
    private String name;
    private Scarcity scarcity;

    // Constructors
    public Drop() {
    }

    public Drop(String name, Scarcity scarcity) {
        this.name = name;
        this.scarcity = scarcity;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setScarcity(Scarcity scarcity) {
        this.scarcity = scarcity;
    }

    // Getters
    public String getName() {
        return name;
    }

    public Scarcity getScarcity() {
        return scarcity;
    }

    // ToString
    @Override
    public String toString() {
        return "Drop{" +
                "name='" + name + '\'' +
                ", scarcity=" + scarcity +
                '}';
    }
}

