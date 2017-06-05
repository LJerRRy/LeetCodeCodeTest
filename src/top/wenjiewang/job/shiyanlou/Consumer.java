package top.wenjiewang.job.shiyanlou;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Jerry on 2017/5/20.
 */
public class Consumer implements Runnable{
    private final BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
            try {
                while(true) {
//                    System.out.println(queue.take().replace("production", "consumption"));
                    System.out.println("Complete consumption:Course"+queue.take()+ " " + Thread.currentThread().getName());
                    Thread.sleep(5000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

    }
}
