package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/27
 */
public class JoinInterrupt implements Runnable {
    public static void main(String[] args)  {
        Thread currentThread = Thread.currentThread();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    currentThread.interrupt();
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "被中断");
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });
        thread.start();
        System.out.println("开始等待子线程执行完毕");
        try {
            thread.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + "被中断");
            thread.interrupt();
            e.printStackTrace();
        }
    }
    @Override
    public void run() {

    }
}
