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
     * �ڶ�β������ݣ�����������������׳�QueueEmptyException
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
     * �Ӷ���ȡ���ݣ��������Ϊ��ʱ���׳�QueueEmptyException
     *
     * @return
     */
    public int get() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("����Ϊ��");
        }else {
            return digits[head++];
        }
    }
}

/**
 * �Զ����쳣��
 */
class QueueEmptyException extends Exception {
    public QueueEmptyException(String message) {
        super(message);
    }
}
