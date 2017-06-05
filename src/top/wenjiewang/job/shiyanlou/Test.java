package top.wenjiewang.job.shiyanlou;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by Jerry on 2017/5/20.
 */
public class Test {
    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new LinkedBlockingDeque<>(5);
        Producer p = new Producer(bq);
        Producer p2 = new Producer(bq);
        Consumer c = new Consumer(bq);
        Thread t1 = new Thread(p);
        Thread t3 = new Thread(p2);
        Thread t2 = new Thread(c);
        t1.start();
        t3.start();
        t2.start();
    }
}
