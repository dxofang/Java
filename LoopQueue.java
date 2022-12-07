package cn.edu.jxnu.util;

public class LoopQueue {
    //声明队列类操作相应的field(attribute)
    private int[] digits;
    private int head=0,tail=0;
    private int status = 0;//0:代表空，1：代表满�?2：代表非空非�?

    public LoopQueue(){
        digits = new int[10];
    }
    public LoopQueue(int capaticy){
        digits = new int[capaticy];
    }

    public void put(int value){
        if(status != 1) {
            digits[tail] = value;
            tail = (tail + 1) % digits.length ;
            if(tail == head) {
                status = 1;
            } else if(status != 2){
                status = 2;
            }
        }
    }

    /**
     * 从队列取数据，如果队列为空，则返回整型变量的朢�小��?
     * @return
     */
    public int get() throws QueueEmptyException {
        int digit = 0;
        if(status != 0){
            digit = digits[head] ;
            head = (head + 1) % digits.length;
            if(head == tail){
                status = 0;
            }
        }else{
            throw new QueueEmptyException("Queue is empty");
            //digit = Integer.MIN_VALUE;
        }
        return digit;
    }

    public boolean isEmpty(){
        boolean flag = true;
        if(status != 0){
            flag =false;
        }
        return flag;
    }
    /**
     * 输出队列
     */
    public void print(){
        int p = head;
        while(status != 0){
            System.out.printf("%d " , digits[p]);
            p = (p + 1) % digits.length;
            if(p == tail){
                break;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws QueueEmptyException {
        LoopQueue queue = new LoopQueue(5);
        try {
            queue.get();
        }  catch (QueueEmptyException e) {
             System.out.println(e.getMessage());
        }
        if(!queue.isEmpty()){
            System.out.println(queue.get());
        }
        queue.put(10);
        queue.put(20);
        queue.put(30);
        queue.put(40);
        queue.print();
        System.out.println(queue.get());
        queue.put(50);
        queue.print();
        queue.put(60);
        queue.print();
        System.out.println(queue.get());
        queue.print();
    }
}



class QueueEmptyException extends Exception {
    //�쳣�����������������
    public QueueEmptyException(String message) {
        super(message);
    }
}