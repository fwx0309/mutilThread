package timer;

import java.util.Random;

public class ThreadLocalDemo {
    static ThreadLocal datas = new ThreadLocal();

    public static void main(String[] args) {
        for (int i = 0; i <2 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //存数据
                    int intData = new Random().nextInt();
                    System.out.println(Thread.currentThread().getName()+"--"+intData);
                    datas.set(intData);

                    //取数据
                    getDataA();
                    getDataB();
                }
            }).start();
        }
    }

    private static void getDataA(){
        System.out.println(Thread.currentThread().getName()+"--methodA--"+datas.get());
    }

    private static void getDataB(){
        System.out.println(Thread.currentThread().getName()+"--methodB--"+datas.get());
    }
}
