package top.wenjiewang.job.shiyanlou;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Jerry on 2017/5/20.
 */
public class Producer implements Runnable{
    private final BlockingQueue<Integer> queue;
    private static AtomicInteger count = new AtomicInteger();

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

            try {
//                while (true) {
                while (true) {
                    synchronized (queue) {
//                        queue.put("Complete production:Course" + count.incrementAndGet());
                    queue.put(count.incrementAndGet());
                    System.out.println("Complete production:Course" + count.get() + Thread.currentThread().getName());

//                    System.out.println("Complete production:Course" + count.get());
                    if (count.get() > 9) break;
                    Thread.sleep(1000);
                    }
                }
//                    System.out.println("Complete production:Course" + count.get());
//                    if (count.compareAndSet(10, 10)) break;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
