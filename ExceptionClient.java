public class ExceptionClient {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.put(60);
        queue.put(70);
        queue.put(80);
        try {
            queue.get();
        } catch (QueueEmptyException e) {
            System.out.println(e.getMessage());
            return;
        }
        try {
            queue.get();
        } catch (QueueEmptyException e) {
            System.out.println(e.getMessage());
            return;
        }
        try {
            queue.get();
        } catch (QueueEmptyException e) {
            System.out.println(e.getMessage());
            return;
        }
        try {
            queue.get();
        } catch (QueueEmptyException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}

class Queue {
    private int[] digits;
    private int head = 0, tail = 0;
    private Queue() {
        this(10);
    }

    public Queue(int capaticy) {
        digits = new int[capaticy];
    }
    /**
     * 在队尾添加数据，如果队列已满，则抛出QueueEmptyException
     *
     * @param value
     */
    public void put(int value) {
        if (!isFull()) {
            digits[tail] = value;
            tail++;
        }
    }

    private boolean isFull() {
        boolean flag = true;
        if (tail < digits.length) {
            flag = false;
        }
        return flag;
    }

    private boolean isEmpty() {
        boolean flag = false;
        if (tail == head) {
            flag = true;
        }
        return flag;
    }

    /**
     * 从队列取数据，如果队列为空时，抛出QueueEmptyException
     *
     * @return
     */
    public int get() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("队列为空");
        }else {
            return digits[head++];
        }
    }
}

/**
 * 自定义异常类
 */
class QueueEmptyException extends Exception {
    public QueueEmptyException(String message) {
        super(message);
    }
}
