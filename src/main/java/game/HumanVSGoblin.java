/*
  FSE Cohort - Project6
  Human VS Goblin
  Class: game.HumanVSGoblin

  - Human (Green Round Square Cell) pursues Goblin(Black Circle Cell) for Drops
  - In console, prints out "You got a drop from the Goblin! It ran away. Pursue again."
  - Click "EXIT" button to exit game
 */
package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;

import game.gameboard.InfoPanel;
import game.gameboard.LandGrid;
import game.treasures.GoblinHolding;
import game.treasures.TreasureBag;

public class HumanVSGoblin {
    public static final String gameTitle = "Human Player(Green Round Square Cell) Pursues Goblin(Black Circle Cell) for Drops";
    public static final int landFrameWidth = 1540;
    public static final int landFrameLength = 820;
    public static final boolean islandFrameVisible = true;
    public static JFrame landFrame = new JFrame();
    public static LandGrid landGrid = new LandGrid(45,28,10,15,25);
    public static InfoPanel infoPanel = new InfoPanel();
    private static JButton btnLeft = new JButton();
    private static JButton btnRight = new JButton();
    private static JButton btnUp = new JButton();
    private static JButton btnDown = new JButton();
    private static JButton btnExit = new JButton();
    public static GoblinHolding goblinHolding = new GoblinHolding(new HashMap<>());
    public static TreasureBag myTreasureBag = new TreasureBag(new ArrayList<>());

    public static void main(String[] args) {
        createGameFrame(); // Create game frame
        addGameButtons(); // Add game buttons
        addLandGrid(); // Add land grid
        addInfoPanel(); // Add info panel
        initInfoPanel(); // initialize greeting msgs in info panel
        goblinHolding.fillGoblinHolding(); // initialize Goblin holdings
        System.out.println("Holdings: "+goblinHolding.getGoblinHoldings());

        // Human moves left via button
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                landGrid.moveLeft();
                if (landGrid.humanCell.getCellX()==landGrid.goblinCell.getCellX() && landGrid.humanCell.getCellY()==landGrid.goblinCell.getCellY())
                {
                    infoPanel.updateInfoPanel(">> Nice job! U got the Goblin's drop! It escaped. Catch it again.");

                    runGoblinRun();
                }
                landFrame.repaint();
            }
        });

        // Game movements
        // Human moves right via button
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                landGrid.moveRight();
                landFrame.repaint();
                if (landGrid.humanCell.getCellX()==landGrid.goblinCell.getCellX() && landGrid.humanCell.getCellY()==landGrid.goblinCell.getCellY())
                {
                    infoPanel.updateInfoPanel(">> Nice job! U got the Goblin's drop! It escaped. Catch it again.");
                    runGoblinRun();
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
                    infoPanel.updateInfoPanel(">> Nice job! U got the Goblin's drop! It escaped. Catch it again.");
                    runGoblinRun();
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
                    infoPanel.updateInfoPanel(">> Nice job! U got the Goblin's drop! It escaped. Catch it again.");
                    runGoblinRun();
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

    // Method: add land frame
    public static void createGameFrame() {
        landFrame.setTitle(gameTitle);
        landFrame.setSize(landFrameWidth,landFrameLength);
        landFrame.setLayout(null);
        landFrame.setVisible(islandFrameVisible);
    }

    // Method: add landgrid
    public static void addLandGrid() {
        landGrid.setBounds(370,0,1200,800);
        landFrame.add(landGrid);
    }

    // Method: add info panel
    public static void addInfoPanel() {
        infoPanel.setBounds(5,15,370,700);
        infoPanel.setBackground(Color.LIGHT_GRAY);
        landFrame.add(infoPanel);
    }

    // Method: init info panel
    public static void initInfoPanel() {
        infoPanel.updateInfoPanel("Hi there, let's catch the Goblin for a drop.");
        infoPanel.updateInfoPanel("-----------------------------------------------------------");
        infoPanel.updateInfoPanel("It'll reveal what u have got for every 5 drops u've gained.");
        infoPanel.updateInfoPanel("Click a button at the bottom of the screen to get moving...");
        infoPanel.updateInfoPanel("Click \"EXIT\" to end the game and close the window.");
        infoPanel.updateInfoPanel("___________________________________________________________");
    }

    // Method: paint buttons
    public static JButton paintButton (String label, int x, int y, int width, int height, JFrame landFrame) {
        // Paint play buttons
        JButton btn = new JButton(label);
        btn.setBounds(x,y,width,height);
        if (label.equals("EXIT")) {
            btn.setBackground(Color.ORANGE);
        } else {
            btn.setBackground(Color.LIGHT_GRAY);
        }
        landFrame.add(btn);
        return btn;
    }

    // Method: add game buttons
    public static void addGameButtons() {
        btnLeft = paintButton("LEFT",500,730,100,25,landFrame);
        btnRight = paintButton("RIGHT",640,730,100,25,landFrame);
        btnUp = paintButton("UP",780,730,100,25,landFrame);
        btnDown = paintButton("DOWN",920,730,100,25,landFrame);
        btnExit = paintButton("EXIT",1200,730,100,25,landFrame);
    }

    // Method: rotate the Goblin
    public static void runGoblinRun () {
        int goblinCellX = (int)(Math.random() * 44 + 1); // bounded by landgrid's cols range
        int goblinCellY = (int)(Math.random() * 27 + 1); // bounded by landgrid's rows range
        landGrid.goblinCell.setCellX(goblinCellX);
        landGrid.goblinCell.setCellY(goblinCellY);
    }
}
