package threadcoreknowledge.stopthreads.volatiledemo;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/26
 */
public class WrongWayVolatile implements Runnable {
    private volatile boolean canceled = false;
    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 10000 && !canceled) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatile r = new WrongWayVolatile();
        Thread thread = new Thread(r);
        thread.start();
        Thread.sleep(2000);
        r.canceled = true;
    }
}
