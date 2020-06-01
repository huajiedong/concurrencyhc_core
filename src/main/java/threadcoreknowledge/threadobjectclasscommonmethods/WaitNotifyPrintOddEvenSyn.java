package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/27
 */
public class WaitNotifyPrintOddEvenSyn {
    private static int count = 0;
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ": " + count);
                            count++;
                        }
                    }
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1) != 0) {
                            System.out.println(Thread.currentThread().getName() + ": " + count);
                            count++;
                        }
                    }
                }
            }
        });
        thread1.start();

        thread.start();
    }



}
