package _6_Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input=reader.readLine();

        while ("Beast!".equals(input)==false){

            String[] tokens=reader.readLine().split("\\s+");

            if(tokens.length!=3){
                System.out.println("Invalid input!");
            }else {

                try {
                    switch (input){
                        case "Animal":{
                            Animal animal=new Animal(tokens[0],tokens[1],tokens[2]);
                            System.out.println(animal.toString());
                            animal.prouceSound();
                        }break;
                        case "Dog":{
                            Dog dog=new Dog(tokens[0],tokens[1],tokens[2]);
                            System.out.println(dog.toString());
                            dog.prouceSound();
                        }break;
                        case "Cat":{
                            Cat cat=new Cat(tokens[0],tokens[1],tokens[2]);
                            System.out.println(cat.toString());
                            cat.prouceSound();
                        }break;
                        case "Frog":{
                            Frog frog=new Frog(tokens[0],tokens[1],tokens[2]);
                            System.out.println(frog.toString());
                            frog.prouceSound();
                        }break;
                        case "Kitten":{
                            Kitten kitten=new Kitten(tokens[0],tokens[1],tokens[2]);
                            System.out.println(kitten.toString());
                            kitten.prouceSound();
                        }break;
                        case "Tomcat":{
                            Tomcat tom=new Tomcat(tokens[0],tokens[1],tokens[2]);
                            System.out.println(tom.toString());
                            tom.prouceSound();
                        }break;
                        default:{
                            System.out.println("Invalid input!");
                        }

                    }
                }catch (IllegalArgumentException error){
                    System.out.println(error.getMessage());
                }

            }
            input=reader.readLine();
        }

    }
}
