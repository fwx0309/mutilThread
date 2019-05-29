package timer;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Exchanger<String> exchanger = new Exchanger<String>();

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String data = "data1";
                System.out.println(Thread.currentThread().getName()+"--"+data);
                try {
                    Thread.sleep((long) (Math.random()*10000));
                    String exchange = exchanger.exchange(data);
                    System.out.println(Thread.currentThread().getName()+"--"+exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                String data = "data2";
                System.out.println(Thread.currentThread().getName()+"--"+data);
                try {
                    Thread.sleep((long) (Math.random()*10000));
                    String exchange = exchanger.exchange(data);
                    System.out.println(Thread.currentThread().getName()+"--"+exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
