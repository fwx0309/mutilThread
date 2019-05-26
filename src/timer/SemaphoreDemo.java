package timer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号灯
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i <10 ; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"进入，有"+(3-semaphore.availablePermits())+"并发。");
                    try {
                        Thread.sleep((long) (Math.random()*10000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"即将离开。");
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName()+"离开，有"+(3-semaphore.availablePermits())+"并发。");
                }
            };
            executorService.execute(runnable);
        }
    }
}
