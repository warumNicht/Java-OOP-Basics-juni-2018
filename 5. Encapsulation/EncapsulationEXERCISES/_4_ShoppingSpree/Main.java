package _4_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder res=new StringBuilder();

        String[] personsInput=reader.readLine().split(";");
        String[] productInput=reader.readLine().split(";");

        List<Product> products=new ArrayList<>();
        List<Person> persons=new ArrayList<>();

        try{
            for (String s : personsInput) {
                String[]persTokens=s.split("=");

                Person curpers=new Person(persTokens[0],Double.parseDouble(persTokens[1]));
                persons.add(curpers);

            }
            for (String product : productInput) {
                String[]prodTokens=product.split("=");

                Product curPr=new Product(prodTokens[0],Double.parseDouble(prodTokens[1]));
                products.add(curPr);
            }
            String input=reader.readLine();
            while ("END".equals(input)==false){

                String[] com=input.split("\\s+");

                String name=com[0];
                String prod=com[1];

                Optional<Person> wantedPerson=persons.stream()
                        .filter(x->x.getName().equals(name))
                        .findFirst();

                Optional<Product> wantProuct=products.stream()
                        .filter(p->p.getName().equals(prod))
                        .findFirst();

                if(wantedPerson.isPresent()&&wantProuct.isPresent()){
                    wantedPerson.get().byProduct(wantProuct.get());
                }

                input=reader.readLine();
            }
            for (Person person : persons) {
                if(person.getProducts().isEmpty()){
                    System.out.printf("%s - Nothing bought%n",person.getName());
                }else {
                    System.out.printf("%s - %s%n",person.getName(),String.join(", ",person.getProducts()));
                }
            }

        }catch (IllegalArgumentException err){
            System.out.println(err.getMessage());
        }

    }
}

