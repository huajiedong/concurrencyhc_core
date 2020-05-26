package threadcoreknowledge.createthreads;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/25
 */
public class BothRunnableThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("我来自thread");
            }
        }.start();
    }
}
