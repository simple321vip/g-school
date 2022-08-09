package cn.violin.home.school.school.concurrent;

/**
 * join method will call Object wait method, as we know wait method need synchronized
 * we can see join is a synchronized method, that the synchronized object is thread object.
 *
 * join will lose sync
 * sleep will not lose sync
 *
 *
 */
public class ThreadJoinDemo {


    public static void main(String[] args) {
        ThreadJoinDemo threadJoinDemo = new ThreadJoinDemo();
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
            Thread.sleep(3000);
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        synchronized (thread1) {
//            thread1.notify();
//        }

    }
}
