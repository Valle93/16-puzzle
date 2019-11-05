import javax.swing.*;

public class FrameSquare extends JButton {

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    private int value;

    public FrameSquare(int value){

        this.value = value;
    }

    public static FrameSquare[][] getFrameSquareArray(){

        FrameSquare[][] fsq = new FrameSquare[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {

                FrameSquare frameSquare = new FrameSquare((i * 4) + j + 1);
                fsq[i][j] = frameSquare;
            }
        }

        return fsq;
    }

}
