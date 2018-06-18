package _3_WildFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Animal> animals=new ArrayList<>();

        String input=reader.readLine();

        while ("End".equals(input)==false){

            String[] tokens=input.split("\\s+");
            Animal currAnimal=null;
            switch (tokens[0]){
                case "Cat":{
                    currAnimal=new Cat(tokens[1],tokens[0],Double.parseDouble(tokens[2]),tokens[3],tokens[4]);
                }break;
                case "Tiger":{
                    currAnimal=new Tiger(tokens[1],tokens[0],Double.parseDouble(tokens[2]),tokens[3]);
                }break;
                case "Zebra":{
                    currAnimal=new Zebra(tokens[1],tokens[0],Double.parseDouble(tokens[2]),tokens[3]);
                }break;
                case "Mouse":{
                    currAnimal=new Mouse(tokens[1],tokens[0],Double.parseDouble(tokens[2]),tokens[3]);
                }break;
            }

            tokens=reader.readLine().split("\\s+");
            Food curFood;
            if(tokens[0].equals("Vegetable")){
                curFood=new Vegetable(Integer.parseInt(tokens[1]));
            }else {
                curFood=new Meat(Integer.parseInt(tokens[1]));
            }
            currAnimal.makeSound();
            currAnimal.eatFood(curFood);
            animals.add(currAnimal);

            input=reader.readLine();
        }

        for (Animal animal : animals) {
            animal.print();
        }

    }
}
