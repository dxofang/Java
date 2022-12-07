public class ConcurrencyClient1 {

    public static void main(String[] args) {

        Counter counter = new Counter();

        Runnable runnable = new Runnable() {//匿名类的写法

            public void run() {

                for (int i = 0; i < 10000; i++) {

                    counter.increment();

                }

            }

        };


        Thread t1 = new Thread(runnable);

        Thread t2 = new Thread(runnable);

        t1.start();

        t2.start();

        try {

            t1.join();

            t2.join();

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

        System.out.println(counter.value());

    }

}

class Counter {

    private int c = 0;

    public void increment() {

        c++;

    }

    public void decrement() {

        c--;

    }

    public int value() {

        return c;

    }

}