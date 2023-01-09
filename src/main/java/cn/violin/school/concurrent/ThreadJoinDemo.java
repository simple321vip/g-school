package cn.violin.school.concurrent;

/**
 * join method will call Object wait method, as we know wait method need synchronized
 * we can see join is a synchronized method, that the synchronized object is thread object.
 *
 * join will lose sync
 * sleep will not lose sync
 * 所以说 线程A 和 B ，在线程A中 调用 B.join()方法，会导致线程A进入等待，不影响B的执行
 *
 *
 */
public class ThreadJoinDemo {


    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                try {
                    System.out.println("11111111");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();


        try {
            System.out.println("22222222");
            Thread.sleep(3000);
            System.out.println("333333");
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("444444444444");
//        synchronized (thread1) {
//            thread1.notify();
//        }

    }
}
