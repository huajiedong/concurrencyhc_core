package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/27
 */
public class Join implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Join());
        Thread thread1 = new Thread(new Join());
        thread.start();
        thread1.start();
        System.out.println("开始等待子线程执行完毕");
        thread.join();
        thread1.join();
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完毕");
    }
}
