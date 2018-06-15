package _6_Stars_FootballTeamGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String,Team> teams=new HashMap<>();

        String input=reader.readLine();

        while ("END".equals(input)==false){

            String[]tokens=input.split(";");
            String curTeam=tokens[1];
            String curPlayer="";

            switch (tokens[0]){
                case "Team":{
                    try {
                        teams.putIfAbsent(curTeam,new Team(curTeam));
                    }catch (IllegalArgumentException exp){
                        System.out.println(exp.getMessage());
                    }

                }break;
                case "Add":{
                    if(teams.containsKey(curTeam)==false){
                        System.out.printf("Team %s does not exist.%n",curTeam);
                    }else{
                        curPlayer=tokens[2];
                        double curEndurance=Double.parseDouble(tokens[3]);
                        double curSprint=Double.parseDouble(tokens[4]);
                        double curDribble=Double.parseDouble(tokens[5]);
                        double curPassing=Double.parseDouble(tokens[6]);
                        double curShooting=Double.parseDouble(tokens[7]);
                        try{
                            Player playerToAdd=new Player(curPlayer,curEndurance,curSprint,curDribble,
                                    curPassing,curShooting);
                            teams.get(curTeam).addPlayer(playerToAdd);
                        }catch (IllegalArgumentException err){
                            System.out.println(err.getMessage());
                        }
                    }

                }break;
                case "Remove":{
                    curPlayer=tokens[2];
                    try{
                        if(teams.containsKey(curTeam)){
                            teams.get(curTeam).removePlayer(curPlayer);
                        }

                    }catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                }break;
                case "Rating":{
                    if(teams.containsKey(curTeam)==false){
                        System.out.printf("Team %s does not exist.%n",curTeam);

                    }else {
                        teams.get(curTeam).setRating();
                        double average=teams.get(curTeam).getRating();

                        System.out.printf("%s - %.0f%n",curTeam,average);
                    }

                }break;
            }
            input=reader.readLine();
        }

    }
}
