/*
  FSE Cohort - Project6
  Human VS Goblin
  Class: GoblinCell
 */
package game;

public class GoblinCell extends Cell{
    // Fields
    int strength;
    String stamina;

    // Constructors

    public GoblinCell() {
    }

    public GoblinCell(int cellX, int cellY, int strength, String stamina) {
        super(cellX, cellY);
        this.strength = strength;
        this.stamina = stamina;
    }

    // Setters
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setStamina(String stamina) {
        this.stamina = stamina;
    }

    // Getters
    public int getStrength() {
        return strength;
    }

    public String getStamina() {
        return stamina;
    }

    // ToString
    @Override
    public String toString() {
        return "GoblinCell{" +
                "strength=" + strength +
                ", stamina='" + stamina + '\'' +
                '}';
    }


}
