package threadcoreknowledge.stopthreads;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/26
 */
public class RightWayStopThreadInProd2 implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("程序响应中断，运行结束");
                break;
            }
            System.out.println("go");
            reInMethod();
        }
    }

    private void reInMethod() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
