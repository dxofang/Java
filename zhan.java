import java.util.Arrays;
import java.util.Scanner;

public class zhan {
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int n=5;
        int [] array = new int[5];
        for(int i=0;i<5;i++)
        {
            array[i]=scanner.nextInt();
        }
        Arrays.sort(array);
        for(int k=0;k<5;k++)
        {
            System.out.printf("%d ",array[k]);
        }

    }
}