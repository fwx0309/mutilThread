package timer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();

    private static int flag = 1;

    public static void main(String[] args) {
        for (int i = 0; i <20 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    print1();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    print2();
                }
            }).start();
        }
    }

    private static void print1(){
        lock.lock();
        try {
            while (flag!=1){
                try {
                    c1.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("print-1");
            flag=2;
            c2.signal();
        } finally {
            lock.unlock();
        }
    }

    private static void print2(){
        lock.lock();
        try {
            while (flag!=2){
                try {
                    c2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("print-2");
            flag=1;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }
}
