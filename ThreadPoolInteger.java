import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ThreadPoolInteger {
    public static void main(String[] agrs) {
        int[] array = new int[20000000];
        Scanner scanner = new Scanner(System.in);
        Long seed;
        seed = scanner.nextLong();
        Random random = new Random();
        random.setSeed(seed);
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(Integer.MAX_VALUE);
        }
        SumTask task = new SumTask(array, 0, array.length);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        long result = forkJoinPool.invoke(task);
        System.out.println(result);
    }
}

class SumTask extends RecursiveTask<Long> {
    final int[] array;
    final int lo, hi;
    public SumTask(int[] array, int lo, int hi) {
        this.array = array;
        this.lo = lo;
        this.hi = hi;
    }

    static final int THRESHOLD = 1000;
    @Override
    protected Long compute() {
        if (THRESHOLD > (lo - hi)) {
            Long a = 0L;
            for (int i : array) {
                a += i;
            }
            return a;
        } else {
            int forkCount = (lo + hi) / 2;
            SumTask left = new SumTask(array, lo, forkCount);
            SumTask right = new SumTask(array, forkCount + 1, hi);
            left.fork();
            right.fork();
            return left.join() + right.join();
        }
    }
}
