/*
  FSE Cohort - Project6
  Human VS Goblin
  Class: HumanCell
 */
package game.gameboard;

public class HumanCell extends Cell{
    // Fields
    private String name;
    private int health;

    // Constructors
    public HumanCell() {
    }

    public HumanCell(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public HumanCell(int cellX, int cellY, String name, int health) {
        super(cellX, cellY);
        this.name = name;
        this.health = health;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    // ToString
    @Override
    public String toString() {
        return "HumanCell{" +
                "name='" + name + '\'' +
                ", health=" + health +
                '}';
    }
}
