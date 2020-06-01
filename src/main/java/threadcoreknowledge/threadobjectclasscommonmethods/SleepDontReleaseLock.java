package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/27
 */
public class SleepDontReleaseLock implements Runnable {

    private static Lock lock = new ReentrantLock();
    @Override
    public void run() {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + "获取到了锁");
        try {
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + "已经苏醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SleepDontReleaseLock s = new SleepDontReleaseLock();
        new Thread(s).start();
        new Thread(s).start();
    }
}
