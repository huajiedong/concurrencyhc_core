package threadcoreknowledge.uncaughtexception;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/06/02
 */
public class MultiThreadError {
    private static Lock lock1 = new ReentrantLock();
    private static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock1.lock();
                    System.out.println(Thread.currentThread().getName() + "获取lock1");
                    Thread.sleep(200);
                    System.out.println(Thread.currentThread().getName() + "尝试获取lock2");
                    lock2.lock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock1.unlock();
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    lock2.lock();
                    System.out.println(Thread.currentThread().getName() + "获取lock2");
                    Thread.sleep(200);
                    System.out.println(Thread.currentThread().getName() + "尝试获取lock1");
                    lock1.lock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock2.unlock();
                }
            }
        });

        thread.start();
        thread1.start();
    }
}
