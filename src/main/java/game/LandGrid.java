/*
  FSE Cohort - Project6
  Human VS Goblin
  Class: LandGrid
 */
package game;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;

public class LandGrid extends JPanel implements GameImplementation{
    // Fields
    private int gridCols=50;
    private int gridRows=28;
    private int origX=55;
    private int origY=15;
    private int cellSize=15;

    public HumanCell humanCell = new HumanCell(25,27,"HUMAN",100);
    public GoblinCell goblinCell = new GoblinCell(18,4,100,"Strong");

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

    // Method: paint
    @Override
    protected void paintComponent(Graphics graph) {
        super.paintComponent(graph);
        Graphics2D graph2D = (Graphics2D)graph;
        drawLandGrid(graph2D);
        drawCell(graph2D,goblinCell.getCellX(),goblinCell.getCellY(),"G");
        drawCell(graph2D,humanCell.getCellX(), humanCell.getCellY(), "H");
    }

    @Override
    public void moveLeft() {
        humanCell.setCellX(humanCell.getCellX()-1);
    }

    @Override
    public void moveRight() {
        humanCell.setCellX(humanCell.getCellX()+1);
    }

    @Override
    public void moveUp() {
        humanCell.setCellY(humanCell.getCellY()-1);
    }

    @Override
    public void moveDown() {
        humanCell.setCellY(humanCell.getCellY()+1);
    }

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
            graph2D.setColor(Color.BLACK);
            graph2D.fillOval(xPosition, yPosition, cellSize, cellSize);
        } else {
            graph2D.setColor(Color.GREEN);
            graph2D.fillRoundRect(xPosition,yPosition,cellSize,cellSize,12,12);
        }
    }
}
