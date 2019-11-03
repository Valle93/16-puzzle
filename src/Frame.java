import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.NORTH;

public class Frame extends JFrame {

    public Frame(){

        JPanel foundation = new JPanel();
        foundation.setLayout(new BorderLayout());
        JPanel north = new JPanel(new GridLayout(1,4));
        JPanel west = new JPanel(new GridLayout(2,1));
        JPanel east = new JPanel(new GridLayout(2,1));
        JPanel south = new JPanel(new GridLayout(1,4));

        JPanel[] färgPaneler = new JPanel[11];

        for (int i = 0; i < 11; i++) {

            JPanel panel = new JPanel();
            färgPaneler[i] = panel;
        }

        foundation.add(färgPaneler[0], NORTH);

        setSize(800,800);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
