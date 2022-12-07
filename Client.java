import java.util.Scanner;

public class Client {

    public static void main(String[] args){

        Shape shape = null;

        Scanner scanner = new Scanner(System.in);

        int category = scanner.nextInt();

        switch(category){

            case 1:

                double edge0 = scanner.nextDouble();

                shape = new Square(edge0);

                System.out.printf("面积:%.2f\r\n",shape.area());

                break;

            case 2:
                double l = scanner.nextDouble();

                double w = scanner.nextDouble();

                shape = new Rectangle(l,w);

                System.out.printf("面积:%.2f\r\n",shape.area());

                break;


            case 3:
                double r = scanner.nextDouble();

                shape = new Circle(r);

                System.out.printf("面积:%.2f\r\n",shape.area());

                break;


            case 4:
                double c = scanner.nextDouble();

                double d = scanner.nextDouble();

                shape = new Triangle(c,d);

                System.out.printf("面积:%.2f\r\n",shape.area());

                break;


        }

    }

}

abstract class Shape {

    //输出一段文本，模拟绘制图形

    public abstract void draw();
    //根据实际数据计算形状面积

    public abstract double area();

}

/**

 * 三角形类

 */

class Triangle extends Shape {
    double a,b;
    public Triangle(double a,double b){
        this.a = a;
        this.b = b;
    }
    public void draw(){
        System.out.println("Draw");
    }
    public double area() {
        return this.a*this.b/2;
    }
}

/**

 * 矩形类

 */

class Rectangle extends Shape {
    double l,w;
    public Rectangle(double l,double w){
        this.l = l;
        this.w = w;
    }
    public void draw(){
        System.out.println("Draw");
    }
    public double area() {
        return this.l*this.w;
    }
}

/**

 * 圆形类

 */

class Circle extends Shape {
    double r;
    public Circle(double r){
        this.r = r;
    }
    public void draw(){
        System.out.println("Draw");
    }
    public double area() {
        return 3.14*this.r*this.r;
    }
}

/**

 * 正方形类

 */

class Square extends Shape {
    double edge;
    public Square(double edge){
        this.edge=edge;
    }
    public void draw(){
        System.out.println("Draw");
    }
    public double area() {
        return this.edge*this.edge;
    }
}