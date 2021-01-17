package net.javaci;

import java.util.concurrent.atomic.AtomicInteger;

public class RaceCondition {
    private static final Object synch = new Object();

    public class Counter {
        private int i;

        public void increment() {
            synchronized (synch) {
                i++;
            }
        }
        public int getValue() {
            return i;
        }
    }

    public Runnable counterThread(Counter counter) {
        return () -> {
            for (int i=0;i<100000; i++) {
                counter.increment();
            }
            System.out.println("i:" + counter.getValue() );
        };
    }

    public void baslat() {
        Counter counter = new Counter();
        new Thread(counterThread(counter)).start();
        new Thread(counterThread(counter)).start();
    }


    public static void main(String[] args) {
        new RaceCondition().baslat();
    }
}
