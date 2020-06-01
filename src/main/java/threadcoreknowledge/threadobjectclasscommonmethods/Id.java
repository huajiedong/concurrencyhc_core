package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/28
 */
public class Id {
    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println(Thread.currentThread().getId());
        System.out.println(thread.getId());
    }
}
