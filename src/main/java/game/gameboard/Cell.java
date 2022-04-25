/*
  FSE Cohort - Project6
  Human VS Goblin
  Class: Cell - base class for grid cells
 */
package game.gameboard;

// Individual grid cell
public class Cell {
    // Fields
    private int cellX;
    private int cellY;

    // Constructors
    public Cell() {
    }

    public Cell(int cellX, int cellY) {
        this.cellX = cellX;
        this.cellY = cellY;
    }

    // Setters
    public void setCellX(int cellX) {
        this.cellX = cellX;
    }

    public void setCellY(int cellY) {
        this.cellY = cellY;
    }

    // Getters
    public int getCellX() {
        return cellX;
    }

    public int getCellY() {
        return cellY;
    }

    // ToString
    @Override
    public String toString() {
        return "Cell{" +
                "cellX=" + cellX +
                ", cellY=" + cellY +
                '}';
    }
}
