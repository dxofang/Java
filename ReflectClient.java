import javax.tools.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
public class ReflectClient {
    /**
     * 装载字符串成为java可执行文件
     * @param className className
     * @param javaCodes javaCodes
     * @return Class
     */
    public static Class<?> compile(String className, String javaCodes) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null, null);
        StrSrcJavaObject srcObject = new StrSrcJavaObject(className, javaCodes);
        Iterable<? extends JavaFileObject> fileObjects = Arrays.asList(srcObject);
        String flag = "-d";
        String outDir = "";
        try {
            File classPath = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());
            outDir = classPath.getAbsolutePath() + File.separator;
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
        Iterable<String> options = Arrays.asList(flag, outDir);
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, options, null, fileObjects);
        boolean result = task.call();
        if (result == true) {
            try {
                return Class.forName(className);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {

        //        String javaSrc = "import java.util.Scanner;\n" +
//                "public class SumTest {\n" +
//                "    public static void main(String[] args){\n" +
//                "        Scanner scanner = new Scanner(System.in);\n" +
//                "        int n = scanner.nextInt();\n" +
//                "        int sum = 0;\n" +
//                "        for(int i = 1 ; i <= n ; i++){\n" +
//                "            sum = sum + i;\n" +
//                "        }\n" +
//                "        System.out.println(sum);\n" +
//                "        scanner.close();\n" +
//                "    }\n" +
//                "}";
//        InputStream iis = new InputStream() {
//            private byte[] bits = "10".getBytes();
//            private int index = 0;
//            @Override
//            public int read() throws IOException {
//                int clone = index++;
//                if (index > bits.length) {
//                    index = 0;
//                    return '\n';
//                }else {
//                    return bits[clone];
//                }
//            }
//        };
//
//        Class<?> cls = ReflectClient.compile("SumTest",javaSrc);
//        System.setIn(iis);
//        ByteArrayOutputStream result = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(result,true));
//        Method method = cls.getDeclaredMethod("main",String[].class);
//        String[] ar = new String[]{"12345"};
//        method.invoke(null,(Object)ar);
//        if(result.toString().replaceAll("\r\n","").equals("55")){
//            System.err.printf("测试通过：%s","success");
//        }
    }
}
class StrSrcJavaObject extends SimpleJavaFileObject
{
    private String content;

    public StrSrcJavaObject(String name, String content)
    {
        super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
        this.content = content;
    }

    public CharSequence getCharContent(boolean ignoreEncodingErrors)
    {
        return content;
    }
}