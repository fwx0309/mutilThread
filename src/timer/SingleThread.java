package timer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * SingleThread 只创建一个线程，当线程死亡时，会再创建一个新的线程。
 */
public class SingleThread {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        //十个任务，一个线程，执行一次
        for (int i = 0; i < 10; i++) {
            final int index = 0;
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" - "+index);
                }
            });
        }

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

        //定时循环执行
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"scheduledAtFixedRate");
            }
        },3,1, TimeUnit.SECONDS);
    }
}
