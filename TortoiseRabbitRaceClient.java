import java.util.Random;

public class TortoiseRabbitRaceClient {

    public static void main(String[] args){
        int distance=1000;
        class  Race implements Runnable{
            Animal athlete;
            public Race(Animal athlete){
                this.athlete=athlete;
            }
            @Override
            public void run() {
                try{
                    athlete.running((distance));
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
        Random random = new Random();
        Animal t1=new Tortoise("tortoise",random.nextInt(10)+20);
        Animal r1=new Rabbit("rabbit",random.nextInt(10)+100);
        Thread thread1=new Thread(new Race(t1));
        Thread thread2=new Thread(new Race(r1));
        thread1.start();
        thread2.start();
    }

}

abstract class Animal {

    String name;

    int speed;



    public Animal(String name, int speed) {

        super();

        this.name = name;

        this.speed = speed;

    }



    public abstract void running(int distance) throws InterruptedException;

}

class Tortoise extends Animal {

    public Tortoise(String name, int speed) {

        super(name, speed);

    }



    @Override

    public void running(int distance) throws InterruptedException {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < distance; i = i + speed) {

            Thread.sleep(10);

        }

        System.out.printf("%s共用时：%d分钟\n",name,System.currentTimeMillis()-startTime);

    }

}



class Rabbit extends Animal {


    public Rabbit(String name, int speed) {
        super(name, speed);
    }

    @Override
    public void running(int distance) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Random random  =new Random();
        int  sleepPoint= random.nextInt();
        boolean sleepy=true;
        for (int i = 0; i < distance; i=i+speed) {
            if(i>=sleepPoint&&sleepy){
                Thread.sleep(random.nextInt(distance/speed)*30);
            }
            Thread.sleep(10);
        }
        System.out.printf("%s用时:%d分钟\n",name,System.currentTimeMillis()-startTime);
    }
}