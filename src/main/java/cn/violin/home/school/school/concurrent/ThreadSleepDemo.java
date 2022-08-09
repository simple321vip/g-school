package cn.violin.home.school.school.concurrent;

/**
 * Thread method join sleep
 * as we know object wait will lose sync
 * but notify will not lose sync
 * sleep will not lose sync
 */
public class ThreadSleepDemo {

    public static void main(String[] args) {
        ThreadSleepDemo threadSleepDemo = new ThreadSleepDemo();

        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("A will sleep 10000");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

        }, "T1");
        thread1.start();

        //
        Thread thread2 = new Thread(() -> {
            while (true) {
                synchronized (threadSleepDemo) {
                    try {
                        System.out.println("B will sleep 10000");
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }

        }, "T2");
        thread2.start();

        Thread thread3 = new Thread(() -> {

            synchronized (threadSleepDemo) {
                try {
                    System.out.println("C will sleep 10000");
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "T3");
        thread3.start();



    }






}
