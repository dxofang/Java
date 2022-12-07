import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class copy {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\Games\\aa");
        File dst = new File("D:\\Game\\issac");
        ByteBuffer src = ByteBuffer.allocate(8092);
        FileChannel inputchannel = new FileInputStream(file).getChannel();
        FileChannel outputchannel = new FileOutputStream(dst).getChannel();
        long start = System.currentTimeMillis();
        while (inputchannel.read(src) != -1) {
            src.flip();
            outputchannel.write(src);
            src.clear();
        }
//        outputchannel.transferFrom(inputchannel, 0, inputchannel.size());
        System.out.printf("×ÜºÄÊ±£º%d\n", System.currentTimeMillis() - start);


    }
}
