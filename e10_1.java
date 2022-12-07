import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class e10_1 {
    public static void main(String[] args) throws IOException {
        File sourceFile = new File("d:\\p1.png");
        File dstfile1 =new File("d:\\p2.png");
        FileInputStream bufferinput = new FileInputStream(sourceFile);
        FileOutputStream bufferoutput = new FileOutputStream(dstfile1);
        Long start = System.currentTimeMillis();
        int c = 0;
        while ((c = bufferinput.read()) !=-1){
            bufferoutput.write(c);
        }
        System.out.printf("共耗时:%d",System.currentTimeMillis()-start);
        bufferinput.close();
        bufferoutput.close();
    }
}
