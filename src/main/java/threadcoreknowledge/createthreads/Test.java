package threadcoreknowledge.createthreads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @Author: HuaChenG
 * @Description:
 * @Date: Create in 2020/05/26
 */
public class Test {
    public static void main(String[] args) {
        //创建分治任务线程池
        ForkJoinPool fjp =
                new ForkJoinPool(4);
        //创建分治任务
        Fibonacci fib =
                new Fibonacci(30);
        //启动分治任务
        long start = System.currentTimeMillis();
        Integer result =
                fjp.invoke(fib);
        //输出结果
        long end = System.currentTimeMillis();
        System.out.println("执行时间：" + (end-start) + "执行结果：" + result);
    }

    //递归任务
    static class Fibonacci extends
            RecursiveTask<Integer> {
        final int n;
        Fibonacci(int n){this.n = n;}
        protected Integer compute(){
            if (n <= 1)
                return n;
            Fibonacci f1 =
                    new Fibonacci(n - 1);
            //创建子任务
            f1.fork();
            Fibonacci f2 =
                    new Fibonacci(n - 2);
            //等待子任务结果，并合并结果
            return f2.compute() + f1.join();
        }
    }
}
