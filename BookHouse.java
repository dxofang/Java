import java.util.Scanner;

public class BookHouse {

    public static void main(String[] args){

        Customer customer = new Customer("张三",5);

        String[] element = null;

        Book book = null;

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        scanner = new Scanner(input);

        scanner.useDelimiter(",");

        while(scanner.hasNext()){

            element = scanner.next().split(" ");

            switch (Integer.parseInt(element[0])){

                case 1:

                    book = new Textbook(element[1],Integer.parseInt(element[2]),element[3]);

                    break;

                case 2:

                    book = new Magazine(element[1],Integer.parseInt(element[2]),element[3]);

                    break;

                case 3:

                    book = new Journal(element[1],Integer.parseInt(element[2]),element[3]);

            }

            book.setDiscount(new Discount(Double.parseDouble(element[4])));

            customer.buy(book);

        }

        System.out.printf("您共计需要付%.2f元",customer.cost());

    }

}

/**

 * 图书

 */

class Book {



}

/**

 * 教程

 */

class Textbook extends Book {

    private String publisher; //出版社





}

/**

 * 杂志

 */

class Magazine extends Book {

    private String author;//作者





}

/**

 * 期刊

 */

class Journal extends Book {

    String category;    //期刊类别：顶级期刊，A类期刊，B类期刊，中文核心期刊





}



/**

 * 顾客

 */

class Customer {



}



/**

 * 折扣

 */

interface IDiscount {

    /**

     * 根据图书原价和折扣率计算图书应付的金额

     * @param price

     * @return

     */

    public double cost(double price);

}

class Discount implements IDiscount {



}

