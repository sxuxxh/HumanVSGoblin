/*
  FSE Cohort - Project6
  Human VS Goblin
  Class: ChefHat - child class from Drop, one of a kind dropped by Goblin
 */
package game.goodies;

public class ChefHat extends Drop {
    // Fields
    private String style;
    private String color;

    // Constructors
    public ChefHat() {
    }

    public ChefHat(String name, Scarcity scarcity, String style, String color) {
        super(name, scarcity);
        this.style = style;
        this.color = color;
    }

    // Setters
    public void setStyle(String style) {
        this.style = style;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Getters
    public String getStyle() {
        return style;
    }

    public String getColor() {
        return color;
    }

    // ToString
    @Override
    public String toString() {
        return "ChefHat{" +
                "name='" + super.getName() + '\'' +
                ", scarcity='" + super.getScarcity() + '\'' +
                ", style='" + style + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
