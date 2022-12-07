import java.util.Random;

public class ConsumerProducer {
    public static void main(String args[]) {
        MessageCenter messageCenter = new MessageCenter();
        Thread t1 = new Thread(new Producer(messageCenter));
        Thread t2 = new Thread(new Consumers(messageCenter));
        t1.start();
        t2.start();
    }
}

class MessageCenter {
    private String[] message = new String[3];
    private int h = 0, t = 0;
    private boolean empty = true;
    private boolean full = false;

    public synchronized String take() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        String s = message[h];
        h = (h + 1) % 3;
        if (h == t) empty = true;
        full = false;
        notifyAll();
        return s;
    }

    public synchronized void put(String m) {
        while (full) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println(m);
        message[t] = m;
        t = (t + 1) % 3;
        empty = false;
        if (h == t) full = true;
        notifyAll();
    }

    public void print() {
        for (String e : message) System.out.println(e);
    }
}

class Producer implements Runnable {
    private MessageCenter messageCenter;

    public Producer(MessageCenter messageCenter) {
        this.messageCenter = messageCenter;
    }

    @Override
    public void run() {
        String importantInfo[] = {
                "教务字 [2022] 48号 关于同意张逸帆同学休学的通知",
                "教务字 [2022] 47号 关于同意刘瑞同学复学的通知",
                "教务字 [2022] 46号 关于同意高萌、杨帆同学降入下一年纪学习的通知",
                "教务字 [2022] 45号 关于2022年在校毕业生进行普通话水平测试的通知",
                "教务字 [2022] 43号 关于推荐线上教学优秀教师的通知",
                "教务字 [2022] 41号 关于阻止学生选课（预选）的通知",
                "教务字 [2022] 40号 关于2022届毕业生提前期末考试具体安排的通知",
                "教务字 [2022] 44号 关于申报2022年教育部产学合作协同育人项目的通知"
        };
        Random random = new Random();

        for (int i = 0; i < importantInfo.length; i++) {
            messageCenter.put(importantInfo[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
            }
        }
        messageCenter.put("DONE");
    }
}

class Consumers implements Runnable {
    private MessageCenter messageCenter;

    public Consumers(MessageCenter messageCenter) {
        this.messageCenter = messageCenter;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (String message = messageCenter.take(); !message.equals("DONE"); message = messageCenter.take()) {
            System.out.format("MESSAGE RECEIVED: %s%n", message);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
            }
        }
    }
}