package threadcoreknowledge.startthread;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/26
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        runnable.run();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
