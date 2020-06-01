package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/27
 */
public class WaitNotifyPrintOddEvenWait {
    private static int count = 0;
    private static Object lock = new Object();


    public static void main(String[] args) {
        new Thread(new TruningRunner()).start();
        new Thread(new TruningRunner()).start();
    }

    static class TruningRunner implements Runnable {
        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "：" + count++);
                    lock.notify();
                    if (count <= 100) {
                        try {
                            //如果任务没有达到count=100的执行结束条件，让出当前线程锁，并休眠
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}

