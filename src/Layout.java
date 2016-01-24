import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

/**
 * Created by Andrew on 2016/1/19.
 */
public class Layout implements MouseListener {

    JPanel mainPanel;
    JFrame theFrame;

    int ROW = 5;
    int COL = 5;

    int rands[];

    boolean isFirstClicked =true;
    boolean isInitial = false;
    boolean isWin = false;

    Block blocks[][];

//    HashMap<Object, Object> hashMap;
    Stack<Integer> stack;

    public Layout() {

    }

    public void buildGUI() {

        theFrame = new JFrame("Schulter");
        theFrame.setTitle("Schulter");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout gridLayout = new GridLayout(5, 5);
        mainPanel = new JPanel(gridLayout);

        blocks = new Block[ROW][COL];

        stack = new Stack<Integer>();
        for (int i = 25; i >= 1; i--) {
            stack.push(i);
        }

        rands = new int[25];

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                Block block = new Block();
                block.addMouseListener(this);
                block.setBackground(Color.gray);
                block.setForeground(Color.white);
                blocks[i][j] = block;
                mainPanel.add(block);
            }
        }
        //theFrame.getContentPane().add(mainPanel);
        theFrame.getContentPane().add(mainPanel);
        theFrame.setBounds(800, 100, 500, 500);
        theFrame.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (isFirstClicked) {
            createRand(25);
            isFirstClicked = false;
            startNewGame();
        }

        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (e.getSource() == blocks[i][j]) {
                    if (isInitial == false) {
                        isInitial = true;
                        break;
                    }

                    int order = getOrder();
                    System.out.println("get order " + order);
                    System.out.println("order " + blocks[i][j].getOrder());
                    if (blocks[i][j].getOrder() == order) {
                        System.out.println(blocks[i][j].getOrder());
                        blocks[i][j].setChecked(true);
                        blocks[i][j].setVisible(false);
                    } else
                        stack.push(stack.peek() - 1);

                }
            }
        }
        checkwin();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

  /*  public void createOrder(int num) {
        *//**

        *//*
        Random random = new Random();
        hashMap = new HashMap<Object, Object>();

        while (hashMap.size() < num) {
            for (int i = 0; i < 25; i++) {
                int n = random.nextInt(25) + 1;
                hashMap.put(n, i);
            }
        }
    }*/

    public void createRand(int num) {

        Random rand = new Random();

        boolean[]  bool = new boolean[num];

        int randInt = 0;

        for(int i = 0; i < num ; i++) {

            do {

                randInt  = rand.nextInt(num) + 1;

            }while(bool[randInt - 1]);

            bool[randInt - 1] = true;

            rands[i] = randInt;

        }
    }

    public void checkwin() {
        if (stack.size() == 0) {
            isWin = true;
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    blocks[i][j].setVisible(true);
                    blocks[i][j].setLabel("");
                }
            }
            blocks[2][0].setLabel("W");
            blocks[2][1].setLabel("I");
            blocks[2][2].setLabel("N");
            blocks[2][3].setLabel("!");

            restartGame();
        }

    }

    public void restartGame() {
        isFirstClicked = true;
        isInitial = false;
        isWin = false;
    }

    public void startNewGame() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                blocks[i][j].setOrder(rands[i * ROW + j]);
                blocks[i][j].setLabel(Integer.toString(rands[i * ROW + j]));
            }
        }
    }

    //

    public int getOrder() {
        return stack.pop();
    }
}
