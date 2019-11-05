import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.awt.BorderLayout.*;
import static java.lang.Thread.sleep;

public class Frame extends JFrame implements ActionListener,MouseListener {

    public static int moves = 0;

    public static JLabel labelMoves = new JLabel("" + moves);

    public static JButton[] functionButtons = new JButton[3];

    public static JPanel foundation = new JPanel();

    JButton[] allaButtons = new JButton[3];

    static JPanel[] färgPaneler = new JPanel[11];

    public Frame(){

        Dimension dimPanels = new Dimension(100,100);

        JButton ljud = new JButton("Ljud Av");

        JButton siffror = new JButton("Siffror På");

        JButton newGame = new JButton("New Game");

        allaButtons[0] = ljud;
        allaButtons[1] = siffror;
        allaButtons[2] = newGame;

        foundation.setLayout(new BorderLayout());
        JPanel north = new JPanel(new GridLayout(1,4));
        JPanel west = new JPanel(new GridLayout(2,1));
        JPanel east = new JPanel(new GridLayout(2,1));
        JPanel south = new JPanel(new GridLayout(1,4));

        JButton[] allaButtons = new JButton[]{ljud,siffror, newGame};

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

        färgPaneler[1].add(Frame.labelMoves);

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

        functionButtons[0] = newGame;
        functionButtons[1] = ljud;
        functionButtons[2] = siffror;

        add(foundation);
        setSize(800,800);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        for (int i = 0; i < 3; i++) {

            functionButtons[i].addActionListener(this);
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                Game.buttons[i][j].addMouseListener(this);
            }
        }


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

        if (Game.ljud) {
            SpelaMusik.PlaySound("src\\youwin.wav");
        }

        JOptionPane.showMessageDialog(null, "Du Klarade Det på " + Frame.moves
        + " drag och " + " minuter och sekunder");

    }

    static void setNumber(){

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                Game.buttons[i][j].setText("" + Game.sq[i][j].getValue());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Game.buttons[Game.tomRuta.getRow()][Game.tomRuta.getColumn()].setVisible(true);

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                if(e.getSource() == Game.buttons[i][j]){

                    Square.moveSquares(Game.sq[i][j]);

                    updateColors();

                    if(Game.number){

                        setNumber();
                    }

                    Frame.labelMoves.setText("" + Frame.moves);

                    checkWinningCondition();
                }
            }
        }


            if(e.getSource() == functionButtons[0]){

                Square.shuffleArray(Game.sq);

                updateColors();

            }

            if(e.getSource() == functionButtons[1]){

                if(Game.ljud){

                Game.ljud = false;

                functionButtons[1].setText("Ljud På");

                }

                else{

                Game.ljud = true;

                functionButtons[1].setText("Ljud Av");

                }

            }
            if(e.getSource() == functionButtons[2]){

                if(Game.number == false){
                    setNumber();

                    functionButtons[2].setText("Siffror av");

                    Game.number = true;
                }
                else{
                    Game.number = false;

                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {

                            Game.buttons[i][j].setText("");
                        }
                    }

                    functionButtons[2].setText("Siffror På");

                }
            }


    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                if(e.getSource() == Game.buttons[i][j]){

                    färgaSaker(allaButtons,färgPaneler,Game.sq[i][j].getColor());
                    Game.somSkaFärgas = Game.buttons[i][j];

                    if (Game.ljud) {
                        SpelaMusik.PlaySound("src\\hover.wav");
                    }

                }
            }
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

