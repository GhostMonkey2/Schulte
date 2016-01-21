import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Random;

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

    Block blocks[][];

    HashMap<Object, Object> hashMap;

    public Layout() {

    }

    public void buildGUI() {

        theFrame = new JFrame("Schulter");
        theFrame.setTitle("Schulter");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout gridLayout = new GridLayout(5, 5);
        mainPanel = new JPanel(gridLayout);

        blocks = new Block[ROW][COL];

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
        theFrame.setBounds(100, 100, 500, 500);
        theFrame.setVisible(true);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (isFirstClicked) {
            for (int i = 0; i < ROW; i++) {
                for (int j = 0; j < COL; j++) {
                    isFirstClicked = false;
                    createRand(25);
                    createOrder(25);
                    blocks[i][j].setOrder(rands[i+j*COL]);
                    blocks[i][j].setLabel(Integer.toString(rands[i+j*COL]));
                }
            }
        }
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (e.getSource() == blocks[i][j]) {
                    if(blocks[i][j].getOrder() == getOrder()) {
                        blocks[i][j].setVisible(false);
                    }

                }
            }
        }

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

    public void createOrder(int num) {
        /**
         等搞明白hashmap再补写这段代码
        */
        Random random = new Random();
        hashMap = new HashMap<Object, Object>();

        while (hashMap.size() < num) {
            for (int i = 0; i < 25; i++) {
                int n = random.nextInt(25) + 1;
                hashMap.put(n, i);
            }
        }
    }

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


    //TODO 自己写数据结构实现此功能

    public int getOrder() {
        Object values[] = new Object[25];
        values = hashMap.keySet().toArray();
        int n = Integer.parseInt(values[0].toString());
        hashMap.remove(n);
        return n;
    }
}
