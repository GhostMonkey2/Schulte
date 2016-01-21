import java.util.HashMap;
import java.util.Random;

/**
 * Created by Andrew on 2016/1/19.
 */
public class test {
    public static void main(String[] args) {
        int MAX = 26;
        /*int rand[] = new int[25];
        for (int i = 0; i < 25; i++) {
            rand[i] = 0;
        }
        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            if(i > 0) {
                for (; i > 0; i--) {

                }
            }
            rand[i] = random.nextInt(MAX);

        }*/

        /*Random random = new Random();
        HashMap<Object, Object> hashMap = new HashMap<Object, Object>();
        Object values[] = new Object[25];

        while (hashMap.size() < 25) {
            for (int i = 0; i < values.length; i++) {
                int num = random.nextInt(25) + 1;
                hashMap.put(num, i);
            }
        }
        values = hashMap.keySet().toArray();
        int num = Integer.parseInt(values[0].toString());
        hashMap.remove(num);
        values = hashMap.keySet().toArray();
        int n = Integer.parseInt(values[0].toString());
        System.out.println(num);
        System.out.println(n);*/
       /* for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
        }*/
        /*int n = 25;
        int rands[] = new int[25];
        Random rand = new Random();

        boolean[]  bool = new boolean[n];

        int randInt = 0;

        for(int i = 0; i < 25 ; i++) {

            do {

                randInt  = rand.nextInt(n) + 1;

            }while(bool[randInt - 1]);

            bool[randInt - 1] = true;

            rands[i] = randInt;

        }
        for (int i = 0; i < 25; i++) {
            System.out.println(rands[i]);
        }*/

    }
}
