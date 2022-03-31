/*
  FSE Cohort - Project6
  Human VS Goblin
  Class: Main

  - Human (Green Round Square Cell) pursues Goblin(Black Circle Cell) for Drops
  - In console, prints out "You got a drop from the Goblin! It ran away. Pursue again."
  - Click "EXIT" button to exit game
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Cell;
import game.LandGrid;

public class Main {
    private static final String gameTitle = "Human Player(Green Round Square Cell) Pursues Goblin(Black Circle Cell) for Drops";
    private static final int landFrameWidth = 1400;
    private static final int landFrameLength = 820;
    private static final boolean islandFrameVisible = true;
    private static JFrame landFrame = new JFrame();
    private static LandGrid landGrid = new LandGrid(50,28,55,15,25);

    public static void main(String[] args) {
        // Paint game frame
        landFrame.setTitle(gameTitle);
        landFrame.setSize(landFrameWidth,landFrameLength);
        landFrame.setLayout(null);

        // Paint play buttons
        JButton btnLeft = new JButton();
        btnLeft = paintButton("LEFT",220,730,100,25,landFrame);
        JButton btnRight = new JButton();
        btnRight = paintButton("RIGHT",360,730,100,25,landFrame);
        JButton btnUp = new JButton();
        btnUp = paintButton("UP",500,730,100,25,landFrame);
        JButton btnDown = new JButton();
        btnDown = paintButton("DOWN",640,730,100,25,landFrame);
        JButton btnExit = new JButton();
        btnExit = paintButton("EXIT",980,730,100,25,landFrame);

        // Paint land grid
        landGrid.setBounds(0,0,1350,800);
        landFrame.add(landGrid);

        // Set frame visible
        landFrame.setVisible(islandFrameVisible);

        // Human moves left via button
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                landGrid.moveLeft();
                landFrame.repaint();
                if (landGrid.humanCell.getCellX()==landGrid.goblinCell.getCellX() && landGrid.humanCell.getCellY()==landGrid.goblinCell.getCellY())
                {
                    rotateGoblin(landFrame,landGrid);
                    System.out.println("You got a drop from the Goblin! It ran away. Pursue again.");
                }
            }
        });

        // Human moves right via button
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                landGrid.moveRight();
                landFrame.repaint();
                if (landGrid.humanCell.getCellX()==landGrid.goblinCell.getCellX() && landGrid.humanCell.getCellY()==landGrid.goblinCell.getCellY())
                {
                    rotateGoblin(landFrame,landGrid);
                    System.out.println("You got a drop from the Goblin! It ran away. Pursue again.");
                }
            }
        });

        // Human moves up via button
        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                landGrid.moveUp();
                landFrame.repaint();
                if (landGrid.humanCell.getCellX()==landGrid.goblinCell.getCellX() && landGrid.humanCell.getCellY()==landGrid.goblinCell.getCellY())
                {
                    rotateGoblin(landFrame,landGrid);
                    System.out.println("You got a drop from the Goblin! It ran away. Pursue again.");
                }
            }
        });

        // Human moves down via button
        btnDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                landGrid.moveDown();
                landFrame.repaint();
                if (landGrid.humanCell.getCellX()==landGrid.goblinCell.getCellX() && landGrid.humanCell.getCellY()==landGrid.goblinCell.getCellY())
                {
                    rotateGoblin(landFrame,landGrid);
                    System.out.println("You got a drop from the Goblin! It ran away. Pursue again.");
                }
            }
        });

        // Player exits game via button
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }

    // Method: paint buttons
    private static JButton paintButton (String label, int x, int y, int width, int height, JFrame landFrame) {
        // Paint play buttons
        JButton btn = new JButton(label);
        btn.setBounds(x,y,width,height);
        if (label.equals("EXIT")) {
            btn.setBackground(Color.YELLOW);
        }
        landFrame.add(btn);
        return btn;
    }

    // Method: rotate the Goblin
    private static void rotateGoblin (JFrame landFrame, LandGrid landGrid) {
        int goblinCellX = (int)(Math.random() * 49 + 1);
        int goblinCellY = (int)(Math.random() * 27 + 1);
        landGrid.goblinCell.setCellX(goblinCellX);
        landGrid.goblinCell.setCellY(goblinCellY);
        landFrame.repaint();
    }
}
