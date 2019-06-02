package timer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ArrayblockingQueue {
    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName()+"-准备放数据;");
                        queue.put(1);
                        System.out.println(Thread.currentThread().getName()+"-放入数据;队列现在有"+queue.size()+"个数据");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName()+"-准备取数据;");
                        Integer take = queue.take();
                        System.out.println(Thread.currentThread().getName()+"-取到数据"+take+";队列现在有"+queue.size()+"个数据");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
