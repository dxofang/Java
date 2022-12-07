import java.sql.SQLOutput;
import java.util.*;
import java.util.function.Consumer;

public class ColletionClient {
    public static void main(String Args[]) {
        List<Integer> scores = new ArrayList<>();
        Integer[] values = new Integer[]{96,65,71,60,80,73,81,76,74,91,76,80,85,78,75,86,85,63,86,68,79,83,89,69,76,66,64,76,65,73,84,71,85,69,79,78,73,66,83,86,74,63,69,71,61,73,74,79,66,73};
        scores = Arrays.asList(values);
        Collections.sort(scores);
        int[] statistics = new int[]{0,0,0,0,0};
        for(Integer score : scores){
            switch(score / 10){
                case 10:
                case 9:
                    statistics[0]++;
                    break;
                case 8:
                    statistics[1]++;
                    break;
                case 7:
                    statistics[2]++;
                    break;
                case 6:
                    statistics[3]++;
                    break;
                default:
                    statistics[4]++;
            }
        }
        System.out.printf("[90:100]：%d\r\n",statistics[0]);
        System.out.printf("[80:89]：%d\r\n",statistics[1]);
        System.out.printf("[70:79]：%d\r\n",statistics[2]);
        System.out.printf("[60:69]：%d\r\n",statistics[3]);
        System.out.printf("[0:59]：%d\r\n",statistics[4]);
        System.out.printf("最高分：%d\r\n",Collections.max(scores));
        System.out.printf("最低分：%d\r\n",Collections.min(scores));

//        Random random = new Random();
//        Integer[] elements = new Integer[10000 * 10000];
//        for (int i = 0; i < elements.length; i++) {
//            elements[i] = random.nextInt(Integer.MAX_VALUE);
//        }
//        scores = Arrays.asList(elements);
//        long start = System.currentTimeMillis();
//        Iterator<Integer> itr = score.iterator();
//        while(itr.hasNext()){
//            System.out.println(itr.next());
//        }
//        System.out.println(System.currentTimeMillis()-start);
//        Collections.sort(scores);
//        for (Integer element : scores) {
//            System.out.println(element);
//        }
//
//        scores.stream().forEach(new TestClass());
//        System.out.println(Collections.min(scores));
    }
}

//class TestClass implements Consumer<Integer> {
//    //    scores.stream().forEach(new Consumer<Integer>);
////    public void accept(Integer integer){
////        System.out.println(integer);
////    }
////    scores.stream.forEach(
////    (score) -> {
////        System.out.println(score);
////    });
//
//
//}