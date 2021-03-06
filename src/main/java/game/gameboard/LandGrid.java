/*
  FSE Cohort - Project6
  Human VS Goblin
  Class: LandGrid - child class from JPanel, defines game land scape, human and goblins positions
 */
package game.gameboard;

import game.HumanVSGoblin;

import javax.swing.*;
import java.awt.*;

public class LandGrid extends JPanel implements IGameMove{
    // Fields
    private int gridCols;
    private int gridRows;
    private int origX;
    private int origY;
    private int cellSize;

    public HumanCell humanCell = new HumanCell(20,26,"HUMAN",0);
    public GoblinCell goblinCell = new GoblinCell(12,10,100,"Strong");
    public GoblinCell goblinCell2 = new GoblinCell(34,7,100,"Strong");

    // Constructors
    public LandGrid() {
    }

    public LandGrid(int gridCols, int gridRows, int origX, int origY, int cellSize) {
        this.gridCols = gridCols;
        this.gridRows = gridRows;
        this.origX = origX;
        this.origY = origY;
        this.cellSize = cellSize;
    }

    //Setters
    public void setGridCols(int gridCols) {
        this.gridCols = gridCols;
    }

    public void setGridRows(int gridRows) {
        this.gridRows = gridRows;
    }

    public void setOrigX(int origX) {
        this.origX = origX;
    }

    public void setOrigY(int origY) {
        this.origY = origY;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    // Getters
    public int getGridCols() {
        return gridCols;
    }

    public int getGridRows() {
        return gridRows;
    }

    public int getOrigX() {
        return origX;
    }

    public int getOrigY() {
        return origY;
    }

    public int getCellSize() {
        return cellSize;
    }

    // ToString
    @Override
    public String toString() {
        return "LandGrid{" +
                "gridCols=" + gridCols +
                ", gridRows=" + gridRows +
                ", origX=" + origX +
                ", origY=" + origY +
                ", cellSize=" + cellSize +
                '}';
    }

    // Method: paint component
    @Override
    protected void paintComponent(Graphics graph) {
        super.paintComponent(graph);
        //graph.drawImage(HumanVSGoblin.imageGameLand, 0, 0, null);
        Graphics2D graph2D = (Graphics2D)graph;
        //drawLandGrid(graph2D); //comment to turn off grid
        drawCell(graph2D,goblinCell.getCellX(),goblinCell.getCellY(),"G");
        drawCell(graph2D,goblinCell2.getCellX(),goblinCell2.getCellY(),"GG");
        drawCell(graph2D,humanCell.getCellX(), humanCell.getCellY(), "H");
    }

    @Override
    public void moveLeft() {
        if (humanCell.getCellX()>=1) { // bounded by landGrid cols range
            humanCell.setCellX(humanCell.getCellX() - 1);
        }
    }

    @Override
    public void moveRight() {
        if (humanCell.getCellX()<42) { // bounded by landGrid cols range
            humanCell.setCellX(humanCell.getCellX() + 1);
        }
    }

    @Override
    public void moveUp() {
        if (humanCell.getCellY()>=1) { // bounded by landGrid rows range
            humanCell.setCellY(humanCell.getCellY() - 1);
        }
    }

    @Override
    public void moveDown() {
        if (humanCell.getCellY()<26) { // bounded by landGrid rows range
            humanCell.setCellY(humanCell.getCellY() + 1);
        }
    }

    @Override
    public void exit() {System.exit(0);}

    // Method: draw land grid
    private void drawLandGrid(Graphics2D graph2D) {
        graph2D.setColor(Color.lightGray);
        // Draw horizontal grid lines
        for (int i=0; i<=gridRows; i++) {
            graph2D.drawLine(origX,origY+i*cellSize,origX+gridCols*cellSize,origY+i*cellSize);
        }
        // Draw vertical grid lines
        for (int i=0; i<=gridCols; i++) {
            graph2D.drawLine(origX+i*cellSize,origY,origX+i*cellSize,origY+gridRows*cellSize);
        }
    }

    // Method: draw Goblin or Human cells
    private void drawCell(Graphics2D graph2D, int x, int y, String type) {
        int xPosition = origX+x*cellSize;
        int yPosition = origY+y*cellSize;
        if (type.equals("G")) {
            graph2D.drawImage(HumanVSGoblin.imageGoblin,null,xPosition,yPosition);
        } else if (type.equals("GG")) {
            graph2D.drawImage(HumanVSGoblin.imageGoblinGreen,null,xPosition,yPosition);
        } else {
            graph2D.drawImage(HumanVSGoblin.imageHuman,null,xPosition,yPosition);
        }
    }
}
