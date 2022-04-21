package game.gameboard;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InfoPanel extends JPanel {
    // Fields


    // Constructors

    // Setters

    // Getters

    // ToString

    // Method: paint component
    @Override
    protected void paintComponent(Graphics graph) {
        super.paintComponent(graph);
    }

    // Method: update info panel
    public void updateInfoPanel(String msg) {
        JLabel jLabel = new JLabel();
        jLabel.setText(msg);
        if (msg.contains(">")) {
            jLabel.setForeground(Color.blue);
        }
        this.add(jLabel);
        this.revalidate(); // must have when new component is added
    }
}

