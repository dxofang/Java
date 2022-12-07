import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

public class Reflection
{
    public static void main(String[] args)
    {
        Player player = new Player();
        InvocationHandler handler = new GameSet(player);
        Game game = (Game) Proxy.newProxyInstance(player.getClass().getClassLoader(), player.getClass().getInterfaces(), handler);
        game.play();
    }


}
class Player implements Game {
    public void play() {
        Games();
    }

    public void Games() {
        for (int i = 0; i < 3; i++) {
            int num = new Random().nextInt(3);
            String a = "";
            switch (num) {
                case 0:
                    a = "Far Cry6";
                    break;
                case 1:
                    a = "Call Of Duty";
                    break;
                case 2:
                    a = "Apex";
                    break;
            }
            if (i==1){
                System.out.print("明天晚上玩");
            }
            if (i==2){
                System.out.print("后天晚上玩");
            }
            System.out.print(a+"\n");
        }
    }
}
class GameSet implements InvocationHandler {
    private Object obj;

    GameSet(Object obj) {
        this.obj = obj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("今天晚上玩");
        Object result = method.invoke(obj, args);
        return result;
    }
}