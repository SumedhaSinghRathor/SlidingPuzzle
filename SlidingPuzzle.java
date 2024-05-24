import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SlidingPuzzle extends Frame implements ActionListener, KeyListener {
    int h, v, move;

    String msg = "Number of Attempts is: ";

    Button b[][] = new Button[4][4];

    Label l1 = new Label("Number Puzzle", Label.CENTER);
    Label l2 = new Label(msg, Label.CENTER);

    Font f1 = new Font("SansSerif", Font.BOLD, 18);
    Font f2 = new Font("SansSerif", Font.BOLD, 16);
    Font f3 = new Font("SansSerif", Font.BOLD, 26);

    int[] solutionArray = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    Panel p = new Panel();

    static void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i >=0; i--) {
            int index = rnd.nextInt(i+1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    boolean checkWinner() {
        int w=1;
        for (int i=0; i<4; i++) {
            for (int j=0; j<4; j++) {
                if(b[i][j].getLabel() != "") {
                    if(Integer.parseInt(b[i][j].getLabel()) != w)
                        break;
                    else
                        w++;
                }
            }
        }

        if(w==15)
            return(true);
        else
            return(false);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(v<3) {
                b[h][v].setLabel(b[h][v+1].getLabel());
                b[h][v+1].setLabel("");
                b[h][v+1].setBackground(Color.white);
                b[h][v].setBackground(Color.pink);
                v++;
                move++;

                if(checkWinner()) {
                    l2.setText("Congrats!!! Number of attempts = " + move);
                } else {
                    l2.setText("Invalid Move!!!");
                }
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(v>0) {
                b[h][v].setLabel(b[h][v-1].getLabel());
                b[h][v-1].setLabel("");
                b[h][v-1].setBackground(Color.white);
                b[h][v].setBackground(Color.pink);
                v--;
                move++;

                if(checkWinner()) {
                    l2.setText("Congrats!!! Number of attempts = " + move);
                } else {
                    l2.setText("Invalid Move!!!");
                }
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(h>0) {
                b[h][v].setLabel(b[h-1][v].getLabel());
                b[h-1][v].setLabel("");
                b[h-1][v].setBackground(Color.white);
                b[h][v].setBackground(Color.pink);
                h--;
                move++;

                if(checkWinner()) {
                    l2.setText("Congrats!!! Number of attempts = " + move);
                } else {
                    l2.setText("Invalid Move!!!");
                }
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_UP) {
            if(h>3) {
                b[h][v].setLabel(b[h+1][v].getLabel());
                b[h+1][v].setLabel("");
                b[h+1][v].setBackground(Color.white);
                b[h][v].setBackground(Color.pink);
                h++;
                move++;

                if(checkWinner()) {
                    l2.setText("Congrats!!! Number of attempts = " + move);
                } else {
                    l2.setText("Invalid Move!!!");
                }
            }
        }
    }

    public static void main(String[] args) {
        SlidingPuzzle c = new SlidingPuzzle("Sliding Grid Puzzle");
        c.setSize(400,450);
        c.setVisible(true);
        c.setResizable(false);
    }

}
