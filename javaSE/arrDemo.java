package javaSE;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by futuration on 2019/7/31.
 */
public class arrDemo {
    public static void main(String args[]) {
        int[] scores = new int[]{11, 22, 33, 44, 55};
        Score score = new Score(scores);
        score.printScore();
        scores[2] = 99;
        score.printScore();
        System.out.println(Arrays.toString(scores));

        Random r = new Random(1111111);
        for (int i = 0; i < 5; i++) {
            System.out.println(r.nextInt(10));
        }
    }

}

class Score {
    private int[] Scores;

    public Score(int[] scores) {
        this.Scores = scores;//这里传递的是引用，所以外部数组更改后，Score内部的数组也会更改
        this.Scores = scores.clone();   // 如果复制一份就不会出现内部数组更改的情况
    }

    public void printScore() {
        System.out.println(Arrays.toString(Scores));
    }


}

