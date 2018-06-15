package _3_AnimalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String name=reader.readLine();
        int age=Integer.parseInt(reader.readLine());

        try{
            Chicken chik=new Chicken(name,age);
            System.out.println(chik.toString());
        }catch (IllegalArgumentException error){
            System.out.println(error.getMessage());
        }

    }
}
