package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/27
 */
public class SleepDontReleaseMonitor implements Runnable {

    public static void main(String[] args) {
        SleepDontReleaseMonitor s = new SleepDontReleaseMonitor();
        new Thread(s).start();
        new Thread(s).start();

    }
    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        System.out.println(Thread.currentThread().getName() + "获取到了锁");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "退出了同步代码块");

    }
}
