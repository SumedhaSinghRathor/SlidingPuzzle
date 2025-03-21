import java.awt.*;
import java.awt.event.*;
import java.util.*;

class SlidingPuzzle extends Frame implements ActionListener, KeyListener {
    int i, j, h, v, move, c;
    
    String msg = "Number of Attempts is";
    
    Button b[][] = new Button[4][4];

    Label l1 = new Label("Number Puzzle",Label.CENTER);
    Label l2 = new Label(msg,Label.CENTER);
    
    Font f1 = new Font("SansSerif", Font.BOLD, 18);
    Font f2 = new Font("SansSerif", Font.BOLD, 16);
    Font f3 = new Font("SansSerif", Font.BOLD, 26);

    int[] solutionArray = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };

    Panel p = new Panel();

    public SlidingPuzzle(String s) {
        super(s);
        setLayout(new BorderLayout());
        move = 0;
        shuffleArray(solutionArray);
        setBackground(Color.yellow);
        
        l1.setFont(f1);
        l2.setFont(f2);

        c=0;

        for(i = 0; i < 4; i++) {
            for(j = 0; j < 4; j++) {
                if(solutionArray[c] == 0) {
                    h = i; v = j;
                    b[i][j] = new Button("");
                    b[i][j].setBackground(Color.white);
                } else {
                    b[i][j] = new Button(String.valueOf(solutionArray[c]));
                    b[i][j].setBackground(Color.pink);
                }
            c++;
            }
        }

        p.setLayout(new GridLayout(4,4));

        for(i = 0; i < 4; i++) {
            for(j = 0; j < 4; j++) {
                b[i][j].setFont(f3);
                p.add(b[i][j]);
            }
        }

        for(i = 0; i < 4; i++) {
            for(j = 0; j < 4; j++) {
                b[i][j].addKeyListener(this);
                add(l1, BorderLayout.NORTH);
                add(p, BorderLayout.CENTER);
                add(l2, BorderLayout.SOUTH);
            }
        }
    }


    static void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i >= 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    boolean checkWinner() {
        int w = 1;

        for(i = 0; i < 4; i++) {
            for(j = 0; j < 4; j++) {
                if(b[i][j].getLabel() != "") {
                    if(Integer.parseInt(b[i][j].getLabel()) != w)
                        break;
                    else
                    w++;
                }
            }
        }

        if (w == 15)
            return(true);
        else
            return(false);
    }

    public void actionPerformed(ActionEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode( ) == KeyEvent.VK_LEFT) {
            if(v < 3) {
                b[h][v].setLabel(b[h][v+1].getLabel());
                b[h][v+1].setLabel("");
                b[h][v+1].setBackground(Color.white);
                b[h][v].setBackground(Color.pink);
                
                v++;
                move++;

                if(checkWinner()) {
                    l2.setText("Congrats !!! Number of attempt= " + move);
                } else {
                    l2.setText(msg + " " + move);
                }
            } else {
                l2.setText("Invalid Move !!!");
            }
        }

        if(e.getKeyCode( ) == KeyEvent.VK_RIGHT) {
            if(v>0) {
                b[h][v].setLabel(b[h][v-1].getLabel());
                b[h][v-1].setLabel("");
                b[h][v-1].setBackground(Color.white);
                b[h][v].setBackground(Color.pink);
                v--;
                move++;

                if(checkWinner()) {
                    l2.setText("Congrats !!! Number of attempt= "+move);
                } else {
                    l2.setText(msg+" "+move);
                }
            } else {
                l2.setText("Invalid Move !!!");
            }
        }

        if(e.getKeyCode( ) == KeyEvent.VK_DOWN) {
            if(h>0) {
                b[h][v].setLabel(b[h-1][v].getLabel());
                b[h-1][v].setLabel("");
                b[h-1][v].setBackground(Color.white);
                b[h][v].setBackground(Color.pink);
                h--;
                move++;

                if(checkWinner()) {
                    l2.setText("Congrats !!! Number of attempt= " + move);
                } else {
                    l2.setText(msg + " " + move);
                }
            } else {
                l2.setText("Invalid Move !!!");
            }
        }

        if(e.getKeyCode( )==KeyEvent.VK_UP) {
            if(h<3) {
                b[h][v].setLabel(b[h+1][v].getLabel());
                b[h+1][v].setLabel("");
                b[h+1][v].setBackground(Color.white);
                b[h][v].setBackground(Color.pink);
                h++;
                move++;

                if(checkWinner()) {
                    l2.setText("Congrats !!! Number of attempt= " + move);
                } else {
                    l2.setText(msg + " " + ove);
                }
            } else {
                l2.setText("Invalid Move !!!");
            }
        }
    }

    public void keyReleased(KeyEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }
    public static void main(String args[]) {
        SlidingPuzzle c=new SlidingPuzzle("Number Grid Puzzle");
        c.setSize(400,550);
        c.show();
        c.setResizable(false);
    }
}
