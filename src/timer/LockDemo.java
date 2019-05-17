package timer;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Synchronized 同步
 */
public class LockDemo {

    private static Lock lock = new ReentrantLock(); //注意这个地方

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    toPrint("sun shang xiang",i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    toPrint("si jia li",i);
                }
            }
        }).start();
    }

    public static void toPrint(String name,Integer time) {
        lock.lock();    //加锁

        try {
            int length = name.length();
            for (int i = 0; i < length; i++) {
                System.out.print(name.charAt(i));
            }
            System.out.print(" - " + time);
            System.out.println();
        } finally {
           lock.unlock();  //代码是否有异常都需要释放锁
        }
    }
}
