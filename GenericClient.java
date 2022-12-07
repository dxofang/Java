import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
public class GenericClient {
    public static void main(String[] args){
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in, "UTF-8"))) {
            try {
                String input = reader.readLine();
                Scanner scanner = new Scanner(input);
                int category = scanner.nextInt();
                switch(category){
                    case 1:
                        Integer[] intValues = new Integer[3];
                        int i = 0;
                        while(scanner.hasNext()){
                            intValues[i++] = scanner.nextInt();
                        }
                        System.out.println(MathUtil.maximum(intValues[0],intValues[1],intValues[2]));
                        break;
                    case 2:
                        Float[] floatsValues = new Float[3];
                        int j = 0;
                        while(scanner.hasNext()){
                            floatsValues[j++] = scanner.nextFloat();
                        }
                        System.out.println(MathUtil.maximum(floatsValues[0],floatsValues[1],floatsValues[2]));
                        break;
                    case 3:
                        Character[] charValues = new Character[3];
                        int m = 0;
                        while(scanner.hasNext()){
                            charValues[m++] = scanner.next().charAt(0);
                        }
                        System.out.println(MathUtil.maximum(charValues[0],charValues[1],charValues[2]));
                        break;
                    case 4:
                        String[] stringValues = new String[3];
                        int n = 0;
                        while(scanner.hasNext()){
                            stringValues[n++] = scanner.next();
                        }
                        System.out.println(MathUtil.maximum(stringValues[0],stringValues[1],stringValues[2]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/**

 * 说明：

 * Comparable<T> interface imposes a total ordering on the objects of each class that implements it. 该接口* 中的compareTo的功能为Compares this object with the specified object for order

 */

class MathUtil{
        public static <T extends Comparable<T>> T maximum(T x,T y,T z) {
            T max = x;// 假设x是初始最大值
            if (y.compareTo(max) > 0) {
                max = y;//y 更大
            }
            if (z.compareTo(z) > 0) {
                max = z;// 现在 z 更大
            }
            return max;// 返回最大对象
        }
}

