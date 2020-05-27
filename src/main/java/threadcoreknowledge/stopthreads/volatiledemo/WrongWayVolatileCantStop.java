package threadcoreknowledge.stopthreads.volatiledemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/26
 */
public class WrongWayVolatileCantStop {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);
        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);
        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()) {
            System.out.println(consumer.storage.take() + "被消费了");
        }
        System.out.println("消费者不需要更多数据了");
        producer.canceled = true;
    }

}
class Producer implements Runnable {
    BlockingQueue storage;
    public volatile boolean canceled = false;
    public Producer(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 10000 && !canceled) {
                if (num % 100 == 0) {
                    storage.put(num);
                    System.out.println(num + "是100的倍数");
                }
                num++;
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者停止运行");
        }
    }
}
class Consumer{
    BlockingQueue storage;
    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }
    public boolean needMoreNums() {
        if (Math.random() > 0.95) {
            return false;
        }
        return true;
    }

}