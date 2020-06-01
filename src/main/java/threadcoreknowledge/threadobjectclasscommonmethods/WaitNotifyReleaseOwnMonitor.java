package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/27
 */
public class WaitNotifyReleaseOwnMonitor {
    private static volatile Object resourceA = new Object();
    private static volatile Object resourceB = new Object();

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread().getName() + "拿到了锁resourceA");
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread().getName() + "拿到了锁resourceB");
                        try {
                            System.out.println(Thread.currentThread().getName() + "释放了锁resourceA");
                            resourceA.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resourceA) {
                    System.out.println(Thread.currentThread().getName() + "拿到了锁resourceA");
                    System.out.println(Thread.currentThread().getName() + "尝试获取锁resourceB");
                    synchronized (resourceB) {
                        System.out.println(Thread.currentThread().getName() + "拿到了锁resourceB");
                    }
                }
            }
        });
        thread.start();
        thread1.start();

    }

}
