public class ConcurrencyClient {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread());
        class TestThread extends Thread{
            @Override
            public void run() {
                for(int i=1;i<=100;i++){
                    System.out.println(i);
                }
            }
        }
        class SecondThread implements Runnable{
            @Override
            public void run() {
                for(int i=200;i<=300;i++){
                    System.out.println(i);
                }
            }
        }

        Thread t = new TestThread();
        Thread t1 = new Thread(new SecondThread());
        t.start();
        t1.start();
        Thread.sleep(1000);
        System.out.println("This is main Thread's output");
    }
}
