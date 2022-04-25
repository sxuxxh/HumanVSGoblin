/*
  FSE Cohort - Project6
  Human VS Goblin
  Class: InfoPanel - child class from JPanel, shows game messages, goody drops and human health...
 */
package game.gameboard;

import game.HumanVSGoblin;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class InfoPanel extends JPanel {
    // Method: paint component
    @Override
    protected void paintComponent(Graphics graph) {
        super.paintComponent(graph);
    }

    // Method: update info panel
    public void updateInfoPanel(String msg) {
        ImageIcon icon = new ImageIcon(HumanVSGoblin.imageGoblin);
        JLabel jLabel = new JLabel();
        JLabel jLabelImg = new JLabel();
        jLabel.setText(msg);
        jLabelImg.setIcon(icon);
        if (msg.contains("Catch Goblin")) {
            jLabel.setFont(new Font("Serif",Font.BOLD,26));
            jLabel.setForeground(new Color(79,67,185));
            this.add(jLabelImg);
        }
        else if (msg.contains("Hi") || msg.contains("Btw")) {
            jLabel.setFont(new Font("Serif",Font.BOLD,14));
        }
        else if (msg.contains("Nice") || msg.contains("Oops")) {
            jLabel.setFont(new Font("Serif",Font.BOLD,13));
            jLabel.setForeground(new Color(79,67,185));
        }
        else if (msg.contains("Health")) {
            jLabel.setFont(new Font("Serif",Font.BOLD,13));
            jLabel.setForeground(new Color(4,138,84));
        }
        else if (msg.contains("Surprised")) {
            jLabel.setFont(new Font("Serif",Font.BOLD,14));
            jLabel.setForeground(new Color(225,40,157));
        }
        else if (msg.contains("*") || msg.contains("peek") || msg.contains("Oops")) {
            jLabel.setFont(new Font("Serif",Font.BOLD,13));
            jLabel.setForeground(new Color(220,128,0));
        } else {
            jLabel.setFont(new Font("Serif",Font.BOLD,14));
        }
        this.add(jLabel);
        this.revalidate(); // must have when new component is added
    }
}

