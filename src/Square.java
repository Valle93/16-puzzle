import javax.swing.*;
import java.awt.*;

public class Square extends JButton {

    public Square(int x, int y, int z){

        this.row = x;
        this.column = y;
        this.value = z;

    }

    private int row;
    private int column;
    private int value;

    public Color getColor() { return color; }

    public void setColor(Color color) { this.color = color; }

    private Color color;

    public int getRow() { return row; }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public static Square[][] getSquareArray(){

        Square[][] sq = new Square[4][4];

        for(int i = 0; i < 4; i++){

            for(int j = 0; j < 4; j++){

                Square square = new Square(i, j, (i * 4) + (j + 1));
                sq[i][j] = square;
            }
        }

        sq = setColors(sq);

        return sq;

    }

    static Square[][] setColors(Square[][] sq){

        int brightness = 205;

        Color[] colors = new Color[4];

        for (int i = 0; i < 4; i++) {

            colors[0] = new Color(brightness, 0, 0);

            colors[1]= new Color(brightness, 0, brightness);

            colors[2] = new Color(0, brightness, brightness);

            colors[3] = new Color(0, 0, brightness);

            for (int j = 0; j < 4; j++) {


                sq[i][j].setColor(colors[j]);
            }

            brightness -= 30;
        }

        sq[3][3].setColor(Color.black);

        return sq;
    }

    public static void shuffleArray(Square[][] sq){

        Square tomRuta = sq[3][3];

        for (int i = 0; i < 10000; i++) {

            double gen = Math.round(0.5 + (Math.random() * 3.49));
            int ran = (int)gen;

            if(ran == 1){

                if(tomRuta.getRow() != 0){

                    Game.gåUpp();
                }
            }

            if(ran == 2){

                if(tomRuta.getRow() != 3) {

                    Game.gåNer();

                }

            }

            if(ran == 3){

                if(tomRuta.getColumn() != 0){

                    Game.gåVänster();


                }

            }

            if(ran == 4) {

                if (tomRuta.getColumn() != 3) {

                    Game.gåHöger();

                }

            }

        }
    }

    public static String toString(Square[][] x){

        String Squares = "";

        for(int i = 0; i < 4; i++){

            for(int j = 0; j < 4; j++){

                Squares += x[i][j].getValue() + "\t\t";
            }

            Squares += "\n";
        }

        return Squares;
    }
/*
    public static void moveSquares(int x, int y){

        Square square = Main.sq[x][y];

        Square tempSquare;

        if(square.getColumn() == Main.tomRuta.getColumn() && square.getRow() == Main.tomRuta.getRow()){

            //spela ingethänderljud (man tryckte på tomruta)
        }

        else if(square.getRow() == Main.tomRuta.getRow()){

            int antalByten = square.getColumn() - Main.tomRuta.getColumn();

            if(antalByten < 0){

                antalByten *= (-1);

                for (int i = 0; i < antalByten; i++) {

                    gåVänster();

                }

            }
            else{

                for (int i = 0; i < antalByten; i++) {

                    gåHöger();

                }


            }

        }

        else if(square.getColumn() == Main.tomRuta.getColumn()){

            int antalByten = square.getRow() - Main.tomRuta.getRow();

            if(antalByten > 0){

                for(int i = 0; i < antalByten; i++){

                    gåNer();

                }
            }
            else{

                antalByten *= (-1);

                for (int i = 0; i < antalByten; i++) {

                    gåUpp();

                }

            }

        }
        else{

            System.out.println("inget ska hända");

            }


    }*/



}
