package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/27
 */
public class JoinThreadStat {
    public static void main(String[] args) throws InterruptedException {
        Thread currentThread = Thread.currentThread();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    System.out.println(currentThread.getState());
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

}
