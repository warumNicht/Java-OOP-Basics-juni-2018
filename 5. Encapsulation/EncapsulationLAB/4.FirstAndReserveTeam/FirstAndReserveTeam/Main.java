package FirstAndReserveTeam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n=Integer.parseInt(reader.readLine());

        Team minior=new Team("Minior");

        for(int i=0; i<n; i++){
            String[] tokens=reader.readLine().split(" ");
            try {
                Person cur=new Person(tokens[0],tokens[1],Integer.parseInt(tokens[2]),Double.parseDouble(tokens[3]));
                minior.addPlayer(cur);
            }catch (IllegalArgumentException error){
                System.out.println(error.getMessage());
            }
        }

        System.out.printf("First team have %d players%n", minior.getFirstTeam().size());
        System.out.printf("Reserve team have %d players", minior.getReserveTeam().size());

    }
}
