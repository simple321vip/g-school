package cn.violin.home.school.school.concurrent;


/**
 * I make this class extends Object class that can read Object class source code easily.
 * in this class I will to learn wait, notify, notifyAll method
 * i compare wait method and sleep method
 * 1. before call wait method, the current thread must own monitor, after called wait method, the current will lose monitor.
 * 2.
 * <p>
 * we can use javap commond to see decompile code like bolew:
 * cd target/classess
 * javap -c cn.violin.home.school.school.concurrent.Class_wait_notify_notifyAll
 */
public class Class_wait_notify_notifyAll extends Object {

    public static void main(String[] args) {

        Class_wait_notify_notifyAll object1 = new Class_wait_notify_notifyAll();

        test_1(object1);
        test2(object1);


    }

    /**
     * if this method is executed, it occur exception: IllegalMonitorStateException.
     * Exception in thread "main" java.lang.IllegalMonitorStateException
     * at java.lang.Object.wait(Native Method)
     * the reason is that the current thread must own this object's monitor. but in this case it not.
     *
     * @param object
     * @throws InterruptedException
     */
    public static void test_1(Class_wait_notify_notifyAll object) {

        System.out.println("--------test_1 start----------");
        try {
            object.wait();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("------------------");
        try {
            synchronized (object) {      // monitorenter
                object.wait();           // monitorexit
            }
        } catch (Exception e) {          // monitorexit
            e.printStackTrace();
        }
        System.out.println("--------test_1 end----------");
    }

    /**
     * Causes the currently executing thread to sleep (temporarily cease
     * execution) for the specified number of milliseconds, subject to
     * the precision and accuracy of system timers and schedulers. The thread
     * does not lose ownership of any monitors.
     */
    public static void test2(Class_wait_notify_notifyAll object) {

        synchronized (object) { // monitorenter
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace(); // monitorexit
            }
        }

    }

}
