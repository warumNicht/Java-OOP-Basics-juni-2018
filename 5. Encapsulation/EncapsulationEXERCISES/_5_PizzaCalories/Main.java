package _5_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[]pizzaTokens=reader.readLine().split("\\s+");
            int n=Integer.parseInt(pizzaTokens[2]);

            Pizza piza=new Pizza(pizzaTokens[1],n);

            String[]pizzaTeig=reader.readLine().split("\\s+");

            Dough dough=new Dough(pizzaTeig[1],pizzaTeig[2],Double.parseDouble(pizzaTeig[3]));

            piza.setDough(dough);

            for(int i=0; i<n; i++){
                String[] tokens=reader.readLine().split("\\s+");
                Topping curr=new Topping(tokens[1],Double.parseDouble(tokens[2]));
                piza.getToppings().add(curr);
            }

            double totalCal=0;
            totalCal+=piza.getDough().calculateCalories();

            for (Topping topping : piza.getToppings()) {
                totalCal+=topping.calculateToppingCal();
            }
            System.out.printf("%s - %.2f%n",piza.getName(),totalCal);

        }catch (IllegalArgumentException error){
            System.out.println(error.getMessage());
        }

    }
}
