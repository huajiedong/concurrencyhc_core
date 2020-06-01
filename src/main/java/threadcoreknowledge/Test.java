package threadcoreknowledge;

import java.util.Date;
import java.util.LinkedList;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/28
 */
public class Test {

    /*private static int count = 0;
    private static Object lock = new Object();
    //用程序实现两个线程交替打印1-100的奇偶数
    public static void main(String[] args) {
        new Thread(new TurnRunnable()).start();
        new Thread(new TurnRunnable()).start();

    }

    static class TurnRunnable implements Runnable {

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
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
    }*/

    //手写生产者消费者模式
    public static void main(String[] args) {
        QueueInfo queueInfo = new QueueInfo();

    }

}

class QueueInfo{
    public static int maxSize;
    public static LinkedList list;

    public QueueInfo() {
        maxSize = 10;
        list = new LinkedList();
    }
}

class Producer implements Runnable {
    private QueueInfo queueInfo;
    public Producer(QueueInfo queueInfo) {
        this.queueInfo = queueInfo;
    }
    public synchronized void put(){
        if (queueInfo.maxSize == 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queueInfo.list.add(new Date());
        System.out.println("队列容量：" + queueInfo.list.size());
        notify();
    }

    @Override
    public void run() {
        put();
    }
}

class Consumer implements Runnable {
    private QueueInfo queueInfo;
    public Consumer(QueueInfo queueInfo) {
        this.queueInfo = queueInfo;
    }
    @Override
    public void run() {
        take();
    }
    public synchronized void take() {
        if (queueInfo.maxSize == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queueInfo.list.add(new Date());
        System.out.println("取走" + queueInfo.list.poll() + "队列容量：" + queueInfo.list.size());
        notify();
    }
}

