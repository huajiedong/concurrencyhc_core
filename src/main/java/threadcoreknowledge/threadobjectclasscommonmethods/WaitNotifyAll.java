package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/27
 */
public class WaitNotifyAll implements Runnable {
    private static final Object resourceA = new Object();
    @Override
    public void run() {
        synchronized (resourceA) {
            System.out.println(Thread.currentThread().getName() + "got resourceA lock.");
            try {
                System.out.println(Thread.currentThread().getName() + "waits to start.");
                resourceA.wait();
                System.out.println(Thread.currentThread().getName() + "waiting to end.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WaitNotifyAll r = new WaitNotifyAll();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    resourceA.notifyAll();
                    System.out.println(Thread.currentThread().getName() + "notifyAll.");
                }
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(200);
        thread3.start();

    }
}
