public class DeadLockClient {

    public static void main(String[] args) throws InterruptedException {

        final Friend zhangsan = new Friend("zhangsan");

        final Friend lisi = new Friend("lisi");


        new Thread(new Runnable() {

            public void run() {

                zhangsan.bow(lisi);

            }

        }).start();
        Thread.sleep(500);
        new Thread(new Runnable() {

            public void run() {

                lisi.bow(zhangsan);

            }

        }).start();

    }

}


class Friend {

    private final String name;


    public Friend(String name) {

        this.name = name;

    }


    public String getName() {

        return this.name;

    }


    public synchronized void bow(Friend bower) {

        System.out.format("%s: %s has bowed to me!%n",

                this.name, bower.getName());

        bower.bowBack(this);

    }


    public synchronized void bowBack(Friend bower) {

        System.out.format("%s: %s has bowed back to me!%n",

                this.name, bower.getName());

    }

}