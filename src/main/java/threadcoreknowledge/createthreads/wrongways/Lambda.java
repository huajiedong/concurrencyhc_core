package threadcoreknowledge.createthreads.wrongways;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/25
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
