package game.treasures;

public class ChefHat extends Drop {
    // Fields
    private String style;
    private String color;

    // Constructors
    public ChefHat() {
    }

    public ChefHat(String name, String style, String color) {
        super(name);
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
                "style='" + style + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
