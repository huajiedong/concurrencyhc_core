package threadcoreknowledge.createthreads.wrongways;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/25
 */
public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
