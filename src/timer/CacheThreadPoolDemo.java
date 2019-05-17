package timer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CacheThreadPool 如果当前线程不够用，就会常见一个新的线程。
 */
public class CacheThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int index = 0;
            //短暂的睡眠时，只用到了一个线程
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" - "+index);
                }
            });
        }
    }
}
