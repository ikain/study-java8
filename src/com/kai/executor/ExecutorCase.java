package com.kai.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by FengKai on 2018/6/12.
 */
public class ExecutorCase {

    private static Executor executor = Executors.newFixedThreadPool(10);
    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        for (int i = 0; i < 1; i++) {
            //executor.execute(new Task());
            // 通过ExecutorService.submit()方法提交的任务，可以获取任务执行完的返回值。
            Future<String> future = executorService.submit(new TaskCallable());
            Future<?> futureN = executorService.submit(new Task());
            Future<Integer> futureC = executorService.submit(new Task(), 1);
            try {
                //System.out.println(futureN.get());
                //System.out.println(future.get());
                System.out.println(futureC.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("thread name:" + Thread.currentThread().getName());
            //throw new NullPointerException();
        }
    }

    static class TaskCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("callable thread name:" + Thread.currentThread().getName());
            return "1";
        }
    }
}
