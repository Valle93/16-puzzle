import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.*;
import static java.lang.Thread.sleep;

public class Frame extends JFrame implements ActionListener {

    static JButton newGame = new JButton("New Game");

    public static JPanel foundation = new JPanel();

    public Frame(){

        Dimension dimPanels = new Dimension(100,100);

        String ljudText = "Ljud På";

        JButton ljud = new JButton(ljudText);

        String siffrorText = "Siffror Av";

        JButton siffror = new JButton(siffrorText);

        /*JPanel foundation = new JPanel();*/

        foundation.setLayout(new BorderLayout());
        JPanel north = new JPanel(new GridLayout(1,4));
        JPanel west = new JPanel(new GridLayout(2,1));
        JPanel east = new JPanel(new GridLayout(2,1));
        JPanel south = new JPanel(new GridLayout(1,4));

        JPanel[] färgPaneler = new JPanel[11];

        JButton[] allaButtons = new JButton[]{ljud,siffror,newGame};

        for (int i = 0; i < 9; i++) {

            JPanel panel = new JPanel();
            färgPaneler[i] = panel;
        }

        for (int i = 0; i < 4; i++) {

            north.add(färgPaneler[i]);
        }

        for (int i = 0; i < 9; i++) {

            färgPaneler[i].setPreferredSize(dimPanels);
        }

        färgaSaker(allaButtons,färgPaneler,Color.RED);

        west.add(färgPaneler[4]);
        west.add(färgPaneler[5]);

        east.add(ljud);
        east.add(siffror);

        south.add(färgPaneler[6]);
        south.add(newGame);
        south.add(färgPaneler[7]);
        south.add(färgPaneler[8]);

        foundation.add(north, NORTH);
        foundation.add(west, WEST);
        foundation.add(east, EAST);
        foundation.add(south, SOUTH);

        JPanel game = new JPanel();
        game.setBackground(Color.BLACK);
        game.setLayout(new GridLayout(4,4));

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                game.add(Game.buttons[i][j]);
                Game.buttons[i][j].addActionListener(this);
            }
        }

        foundation.add(game, CENTER);

        Square.shuffleArray(Game.sq);

        updateColors();

        add(foundation);
        setSize(800,800);
        setVisible(true);
        setLocationRelativeTo(null);


    }

    static void färgaSaker(JButton[] allaButtons, JPanel[] allaPaneler, Color färg){

        for (int i = 0; i < 3; i++) {

            allaButtons[i].setBackground(färg);
        }

        for (int i = 0; i < 9; i++) {

            allaPaneler[i].setBackground(färg);
        }

    }

    public static void updateColors(){

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                Game.buttons[i][j].setBackground(Game.sq[i][j].getColor());

            }
        }

        Game.buttons[Game.tomRuta.getRow()][Game.tomRuta.getColumn()].setVisible(false);



    }

    static void checkWinningCondition() {

        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                if (Game.sq[i][j].getValue() != (i * 4) + j + 1) {
                    return;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Du klarade Det!");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Game.buttons[Game.tomRuta.getRow()][Game.tomRuta.getColumn()].setVisible(true);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                if(e.getSource() == Game.buttons[i][j]){

                    Square.moveSquares(Game.sq[i][j]);

                    updateColors();

                    checkWinningCondition();
                }
            }
        }

        if(e.getSource() == newGame){

            Square.shuffleArray(Game.sq);

            updateColors();

            System.out.println("hola hallå");
        }

    }
}
