/*
  FSE Cohort - Project6
  Human VS Goblin
  Main Class: game.HumanVSGoblin

  - Human (Green Round Square Cell) pursues Goblin(Black Circle Cell) for goody drops
  - Watch messages in info panel for goody drops, human health and surprised prizes
  - Click "EXIT" button to exit game
 */
package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import game.gameboard.GoblinCell;
import game.gameboard.InfoPanel;
import game.gameboard.LandGrid;
import game.goodies.*;

public class HumanVSGoblin {
    public static final String gameTitle = "Human Player(Green Round Square Cell) Pursues Goblin(Brown Circle Cell) for Goody Drops";
    public static final int landFrameWidth = 1505;
    public static final int landFrameLength = 800;
    public static final boolean islandFrameVisible = true;
    public static JFrame gameFrame = new JFrame();
    public static LandGrid landGrid = new LandGrid(43,27,10,15,25);
    public static InfoPanel infoPanel = new InfoPanel();
    private static JButton btnLeft = new JButton();
    private static JButton btnRight = new JButton();
    private static JButton btnUp = new JButton();
    private static JButton btnDown = new JButton();
    private static JButton btnGoody = new JButton();
    private static JButton btnHealth = new JButton();
    private static JButton btnExit = new JButton();
    public static GoblinHolding goblinHolding = new GoblinHolding(new HashMap<Integer,Drop>());
    public static GoodyBag myGoodyBag = new GoodyBag(new ArrayList<Drop>());
    public static int dropCount = 1;
    public static BufferedImage imageGoblin = null;
    public static BufferedImage imageHuman = null;
    public static BufferedImage imageGoblinGreen = null;

    public static void main(String[] args) {
        // Login can be added here
        drawGameFrame(); // Create game frame
        addGameButtons(); // Add game buttons
        try { //get Goblin image
            imageGoblin = ImageIO.read(new File("C:\\Users\\sxuxxh\\projects\\HumanVSGoblin\\src\\main\\resources\\goblin_red_small.png"));
            imageHuman = ImageIO.read(new File("C:\\Users\\sxuxxh\\projects\\HumanVSGoblin\\src\\main\\resources\\human_small.png"));
            imageGoblinGreen = ImageIO.read(new File("C:\\Users\\sxuxxh\\projects\\HumanVSGoblin\\src\\main\\resources\\goblin_green.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        addLandGrid(); // Add land grid
        addInfoPanel(); // Add info panel
        initInfoPanel(); // initialize greeting msgs in info panel
        goblinHolding.fillGoblinHolding(); // stock up Goblin holdings
        //System.out.println("Holdings: "+goblinHolding.getGoblinHoldings());

        // Human moves left via button
        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                landGrid.moveLeft();
                if (landGrid.humanCell.getCellX()==landGrid.goblinCell.getCellX() && landGrid.humanCell.getCellY()==landGrid.goblinCell.getCellY())
                {
                    processADrop("1");
                }
                if (landGrid.humanCell.getCellX()==landGrid.goblinCell2.getCellX() && landGrid.humanCell.getCellY()==landGrid.goblinCell2.getCellY())
                {
                    processADrop("2");
                }
                gameFrame.repaint();
            }
        });

        // Game actions/movements
        // Human moves right via button
        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                landGrid.moveRight();
                //gameFrame.repaint();
                if (landGrid.humanCell.getCellX()==landGrid.goblinCell.getCellX() && landGrid.humanCell.getCellY()==landGrid.goblinCell.getCellY())
                {
                    processADrop("1");
                }
                if (landGrid.humanCell.getCellX()==landGrid.goblinCell2.getCellX() && landGrid.humanCell.getCellY()==landGrid.goblinCell2.getCellY())
                {
                    processADrop("2");
                }
                gameFrame.repaint();
            }
        });

        // Human moves up via button
        btnUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                landGrid.moveUp();
                //gameFrame.repaint();
                if (landGrid.humanCell.getCellX()==landGrid.goblinCell.getCellX() && landGrid.humanCell.getCellY()==landGrid.goblinCell.getCellY())
                {
                    processADrop("1");
                }
                if (landGrid.humanCell.getCellX()==landGrid.goblinCell2.getCellX() && landGrid.humanCell.getCellY()==landGrid.goblinCell2.getCellY())
                {
                    processADrop("2");
                }
                gameFrame.repaint();
            }
        });

        // Human moves down via button
        btnDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                landGrid.moveDown();
                //gameFrame.repaint();
                if (landGrid.humanCell.getCellX()==landGrid.goblinCell.getCellX() && landGrid.humanCell.getCellY()==landGrid.goblinCell.getCellY())
                {
                    processADrop("1");
                }
                if (landGrid.humanCell.getCellX()==landGrid.goblinCell2.getCellX() && landGrid.humanCell.getCellY()==landGrid.goblinCell2.getCellY())
                {
                    processADrop("2");
                }
                gameFrame.repaint();
            }
        });

        // Show goodies via button
        btnGoody.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                myGoodyBag.showGoody();
                gameFrame.repaint();
            }
        });

        // Show my health points via button
        btnHealth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                showHealth();
                gameFrame.repaint();
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

    // Other methods
    // Method: add land frame
    public static void drawGameFrame() {
        gameFrame.setTitle(gameTitle);
        gameFrame.setSize(landFrameWidth,landFrameLength);
        gameFrame.setLayout(null);
        gameFrame.setVisible(islandFrameVisible);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Method: add landgrid
    public static void addLandGrid() {
        landGrid.setBounds(388,15,1095,695);
        landGrid.setBackground(new Color(196,171,171));
        landGrid.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
        gameFrame.add(landGrid);
    }

    // Method: add info panel
    public static void addInfoPanel() {
        infoPanel.setBounds(3,15,378,735);
        infoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        infoPanel.setBackground(new Color(218,205,205));
        gameFrame.add(infoPanel);
    }

    // Method: init info panel
    public static void initInfoPanel() {
        infoPanel.updateInfoPanel("Catch Goblin for Goody Drops");
        //infoPanel.updateInfoPanel("___________________________________________________________");
        infoPanel.updateInfoPanel("Hi, click a button on the bottom of the screen to get going...");
        infoPanel.updateInfoPanel("Btw, you'll get a surprise reward for every 3 drops.");
        //infoPanel.updateInfoPanel("Click \"EXIT\" to end the game and close the window.");
        infoPanel.updateInfoPanel("===========================================================");
    }

    // Method: add game buttons
    public static void addGameButtons() {
        btnLeft = paintButton("GO LEFT",480,725,95,25,gameFrame);
        btnRight = paintButton("GO RIGHT",600,725,95,25,gameFrame);
        btnUp = paintButton("GO UP",720,725,95,25,gameFrame);
        btnDown = paintButton("GO DOWN",840,725,95,25,gameFrame);
        btnGoody = paintButton("MY GOODIES",960,725,123,25,gameFrame);
        btnHealth = paintButton("MY HEALTH PTS",1110,725,135,25,gameFrame);
        btnExit = paintButton("EXIT",1300,725,90,25,gameFrame);
    }

    // Method: paint buttons
    public static JButton paintButton (String label, int x, int y, int width, int height, JFrame gameFrame) {
        // Paint play buttons
        JButton btn = new JButton(label);
        btn.setBounds(x,y,width,height);
        if (label.equals("EXIT")) {
            btn.setBackground(Color.RED);
        } else if (label.contains("GOODIES")) {
            btn.setBackground(new Color(225,128,0));
        } else if (label.contains("HEALTH")) {
            btn.setBackground(new Color(7,196,26));
        } else {
            btn.setBackground(Color.LIGHT_GRAY);
        }
        gameFrame.add(btn);
        return btn;
    }

    // Method: rotate the Goblin
    public static void runGoblinRun (String goblinCellNum) {
        int goblinCellX = (int)(Math.random() * 41 + 1); // bounded by landgrid's cols range
        int goblinCellY = (int)(Math.random() * 26 + 1); // bounded by landgrid's rows range
        if (goblinCellNum.equals("1")) {
            landGrid.goblinCell.setCellX(goblinCellX);
            landGrid.goblinCell.setCellY(goblinCellY);
        }
        if (goblinCellNum.equals("2")) {
            landGrid.goblinCell2.setCellX(goblinCellX);
            landGrid.goblinCell2.setCellY(goblinCellY);
        }
    }

    // Method: process human moves
    public static void processADrop(String goblinCellNum) {
        infoPanel.updateInfoPanel("> Nice! U got a goody drop from Goblin. It ran away. Catch it again.");
        myGoodyBag.addADrop();
        if (dropCount>0 && dropCount%3==0) {
            infoPanel.updateInfoPanel(gainHealth());
        }
        dropCount+=1;
        runGoblinRun(goblinCellNum);
    }

    // Method: gain random (1-10) human health pts every 3 drops
    public static String gainHealth() {
        int health = landGrid.humanCell.getHealth();
        int gainPts = goblinHolding.getRandomInt();
        health += gainPts;
        landGrid.humanCell.setHealth(health);
        String msg = "> Surprised and Congrats! U've gained "+String.valueOf(gainPts)+" points in health.";
        return msg;
    }

    // Method: show my health-pt
    public static void showHealth() {
        String health = String.valueOf(landGrid.humanCell.getHealth());
        if (landGrid.humanCell.getHealth() > 0) {
            infoPanel.updateInfoPanel("> My total Health-Points: " + health);
        } else {
            infoPanel.updateInfoPanel("> Oops, no Health-Points. You got this! ");
        }
    }
}
