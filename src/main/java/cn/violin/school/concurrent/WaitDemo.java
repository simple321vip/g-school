package cn.violin.school.concurrent;

public class WaitDemo {

    int counter;

    public synchronized void plus() {
        if (this.counter != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.counter++;
        System.out.print(this.counter);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.notify();
    }

    public synchronized void minus() {
        if (this.counter == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.counter--;
        System.out.print(this.counter);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.notify();
    }

    public static void main(String[] args) {

        WaitDemo waitDemo = new WaitDemo();
        new Thread(() -> {
            while (true) {
                waitDemo.plus();
            }
        }).start();

        new Thread(() -> {
            while (true) {
                waitDemo.minus();
            }
        }).start();

    }


}
