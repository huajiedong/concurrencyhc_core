package threadcoreknowledge.jmm;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/06/03
 */
public class OutOfOrderExecution {

    private static int x = 0, y = 0;
    private static int a = 0, b = 0;


    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (;;) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            CountDownLatch countDownLatch = new CountDownLatch(1);
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1;
                    x = b;
                }
            });

            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1;
                    y = a;
                }
            });
            thread2.start();
            thread1.start();
            countDownLatch.countDown();
            thread1.join();
            thread2.join();

            System.out.println("第" + i + "次执行。 " + "x = " + x + " , y = " + y);
            if (x == 0 && y == 0) {
                break;
            }
        }
    }
}
