package timer;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器案例
 */
public class TimerTest {
    public static void main(String[] args) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时器执行");
            }
        },4000,2000);

        while (true){
            System.out.println(new Date().getSeconds());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
