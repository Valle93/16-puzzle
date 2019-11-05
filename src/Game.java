public class Game {

    public static boolean number = false;

    public static Square[][] sq = Square.getSquareArray();

    public static Square tomRuta = sq[3][3];

    public static FrameSquare[][] buttons = FrameSquare.getFrameSquareArray();

    public static FrameSquare somSkaFärgas = null;

    public static MouseListenerThread gradvisFärga;



    public static void gåUpp(){

        Square tempSquare;

        tempSquare = sq[tomRuta.getRow() - 1][tomRuta.getColumn()];

        sq[tomRuta.getRow() - 1][tomRuta.getColumn()] = tomRuta;

        tempSquare.setRow(tempSquare.getRow() + 1);

        sq[tomRuta.getRow()][tomRuta.getColumn()] = tempSquare;

        tomRuta.setRow(tomRuta.getRow() - 1);

        Frame.moves++;

    }

    public static void gåNer(){

        Square tempSquare;

        tempSquare = sq[tomRuta.getRow() + 1][tomRuta.getColumn()];

        sq[tomRuta.getRow() + 1][tomRuta.getColumn()] = tomRuta;

        tempSquare.setRow(tempSquare.getRow() - 1);

        sq[tomRuta.getRow()][tomRuta.getColumn()] = tempSquare;

        tomRuta.setRow(tomRuta.getRow() + 1);

        Frame.moves++;
    }

    public static void gåVänster(){

        Square tempSquare;

        tempSquare = sq[tomRuta.getRow()][tomRuta.getColumn() - 1];

        sq[tomRuta.getRow()][tomRuta.getColumn() - 1] = tomRuta;

        tempSquare.setColumn(tempSquare.getColumn() + 1);

        sq[tomRuta.getRow()][tomRuta.getColumn()] = tempSquare;

        tomRuta.setColumn(tomRuta.getColumn() - 1);

        Frame.moves++;

    }

    public static void gåHöger(){

        Square tempSquare;

        tempSquare = sq[tomRuta.getRow()][tomRuta.getColumn() + 1];

        sq[tomRuta.getRow()][tomRuta.getColumn() + 1] = tomRuta;

        tempSquare.setColumn(tempSquare.getColumn() - 1);

        sq[tomRuta.getRow()][tomRuta.getColumn()] = tempSquare;

        tomRuta.setColumn(tomRuta.getColumn() + 1);

        Frame.moves++;
    }
}
