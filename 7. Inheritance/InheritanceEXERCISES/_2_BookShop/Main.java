package _2_BookShop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {

            String author=reader.readLine();
            String title=reader.readLine();
            double price=Double.parseDouble(reader.readLine());

            Book book=new Book(author,title,price);

            GoldenEditionBook goldenEditionBook=new GoldenEditionBook(author,
                    title,
                    price);

            Method[] bookDeclaratedMathods=Book.class.getDeclaredMethods();
            Method[] goldenBookDeclaredMethos=GoldenEditionBook.class.getDeclaredMethods();

            if(goldenBookDeclaredMethos.length>1){
                throw new IllegalArgumentException("Code duplication in GoldenEditionBook!");
            }
            System.out.println(book.toString());
            System.out.println(goldenEditionBook.toString());


        }catch (IllegalArgumentException error){
            System.out.println(error.getMessage());
        }

    }
}
