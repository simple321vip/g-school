package cn.violin.school.concurrent;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现一个容器，提供两个方法，add，size，写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，当个数到5个时，线程2给出提示并结束
 */
public class WaitDemo2 {

    public List<Object> lists = new ArrayList<>();

    public static void main(String[] args) {
        WaitDemo2 waitDemo2 = new WaitDemo2();

        // 获取对象锁，当size—5的时候， 唤醒其他处于 wait set状态的线程，而自身执行到wait代码后 让出锁，自身进入 wait set状态
        // 只有 别线程调通notify后，自己被唤醒，才会继续执行
        new Thread(() -> {
            synchronized (waitDemo2) {
                for (int i = 0; i < 10; i++) {
                    waitDemo2.add(new Object());

                    if (waitDemo2.size() == 5) {
                        waitDemo2.notify();
                        try {
                            waitDemo2.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        }).start();


        // 此线程 如果获取到 对象锁，去判断size，如果不是5，就进入等待状态wait set，
        // 让出锁，只有被唤醒后才会往下执行，通知处于wait set状态的线程唤醒
        new Thread(() -> {
            synchronized (waitDemo2) {

                if (waitDemo2.size() != 5) {
                    try {
                        waitDemo2.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(" to closed this thread that 5");
                waitDemo2.notify();
            }
        }).start();

    }

    public int size() {
        return this.lists.size();
    }

    public void add(Object o) {
        this.lists.add(o);
    }

}
