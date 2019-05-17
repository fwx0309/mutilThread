package timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledThreadPool 预定一定时间后执行一次或多次。
 */
public class ScheduledThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        //只执行一次
        for (int i = 0; i < 5; i++) {
            final int index = 0;
            scheduledExecutorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" - 执行。" + index);
                }
            },2, TimeUnit.SECONDS);
        }
        System.out.println("----------------------------");

        //循环执行
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" - 执行。(循环)");
            }
        },3,1,TimeUnit.SECONDS);
    }
}
