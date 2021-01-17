package net.javaci;

public class Main {

    public static class CharThread extends Thread {
        private char c;
        public CharThread(char c) {
            this.c = c;
        }
        @Override
        public void run() {
            for (int i=0; i<25; i++) {
                System.out.print(c);
            }
        }
    }

    public static void main2(String[] args) {
        new CharThread('a').start();
        new CharThread('b').start();
        new CharThread('c').start();

    }

    public static class LoopThread extends Thread {
        @Override
        public void run() {
            int i=0;
            System.out.println("thread basladi:" + Thread.currentThread().getName());
            while(true) {
                i++;
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i%10000 == 0) {
                    //System.out.println(Thread.currentThread().getName() + "-" + i);
                    break;
                }
                if (false)
                    break;

            }
            System.out.println("thread bitti:" + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        new LoopThread().start();
        new LoopThread().start();
        new LoopThread().start();
        new LoopThread().start();
        System.out.println("main bitti");
    }
}
