package SortPersonsByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());

        List<Person> persons=new ArrayList<>();

        for(int i=0; i<n; i++){
            String[] tokens=reader.readLine().split(" ");
            persons.add(new Person(tokens[0],tokens[1],Integer.parseInt(tokens[2])));
        }

        Collections.sort(persons,(a,b)->{
            int firstCriterium=a.getFirstName().compareTo(b.getFirstName());
            if(firstCriterium==0){
                return Integer.compare(a.getAge(),b.getAge());
            }
            return firstCriterium;
        });
        for (Person person : persons) {
            System.out.println(person.toString());
        }

    }
}
