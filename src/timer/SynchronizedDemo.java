package timer;

/**
 * Synchronized 同步
 */
public class SynchronizedDemo {
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

    public synchronized static void toPrint(String name,Integer time) {
        int length = name.length();
        for (int i = 0; i < length; i++) {
            System.out.print(name.charAt(i));
        }
        System.out.print(" - " + time);
        System.out.println();
    }
}
