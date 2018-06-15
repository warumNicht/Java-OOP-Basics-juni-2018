package _6_Stars_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Team {
    private String name;
    private double rating;
    private List<Player> players;

    public Team(String name) {
        setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if(name==null||name.replaceAll("\\s+","").length()==0){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    void setRating() {
        if(players.size()>0){
            double sum=0;
            int count=0;
            for (Player player : players) {
                count++;
                sum+=player.sumPlayerSkills();
            }
            this.rating = sum/(count*5);
        }
    }
    public void removePlayer(String player){

        Optional<Player> playerToRemove=players.stream()
                .filter(x->x.getName().equals(player))
                .findFirst();

        if(playerToRemove.isPresent()){
            players.remove(playerToRemove.get());
        }else {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.",player,this.name));
        }

    }
    public void addPlayer(Player player){
        this.players.add(player);
    }

    public double getRating() {
        return rating;
    }
}
