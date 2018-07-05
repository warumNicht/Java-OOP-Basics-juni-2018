package Avatar.models;

import Avatar.models.Benders.*;
import Avatar.models.Monuments.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WarManager {
    List<String> warIssues;
    HashMap<String,Nation> nations;

    public WarManager() {
        this.warIssues = new ArrayList<>();
        HashMap<String,Nation> nat=new HashMap<>();
        nat.put("Air",new Nation());
        nat.put("Water",new Nation());
        nat.put("Fire",new Nation());
        nat.put("Earth",new Nation());
        this.nations = nat;
    }
    public void war(String initialozator){
        this.warIssues.add(initialozator);
        this.nations.values().stream()
                .sorted((x,y)->{
                    double totalPowX=x.calculateTotalPower();
                    double totalPowY=y.calculateTotalPower();
                    return Double.compare(totalPowY,totalPowX);
                })
                .skip(1)
                .forEach(n->n.clear());
    }
    public void addNewBender(String input){
        String[]tokens=input.split("\\s+");
        switch (tokens[1]){
            case "Air":{
                Bender bender=new AirBender(tokens[2],Integer.parseInt(tokens[3]),Double.parseDouble(tokens[4]));
                this.nations.get("Air").addBender(bender);
            }break;
            case "Water":{
                Bender bender=new WaterBender(tokens[2],Integer.parseInt(tokens[3]),Double.parseDouble(tokens[4]));
                this.nations.get("Water").addBender(bender);
            }break;
            case "Fire":{
                Bender bender=new FireBender(tokens[2],Integer.parseInt(tokens[3]),Double.parseDouble(tokens[4]));
                this.nations.get("Fire").addBender(bender);
            }break;
            case "Earth":{
                Bender bender=new EarthBender(tokens[2],Integer.parseInt(tokens[3]),Double.parseDouble(tokens[4]));
                this.nations.get("Earth").addBender(bender);
            }break;
        }

    }
    public void addNewMonument(String input){
        String[]tokens=input.split("\\s+");
        switch (tokens[1]){
            case "Air":{
                Monument monument=new AirMonument(tokens[2],Integer.parseInt(tokens[3]));
                this.nations.get("Air").addMonument(monument);
            }break;
            case "Water":{
                Monument monument=new WaterMonument(tokens[2],Integer.parseInt(tokens[3]));
                this.nations.get("Water").addMonument(monument);
            }break;
            case "Fire":{
                Monument monument=new FireMonument(tokens[2],Integer.parseInt(tokens[3]));
                this.nations.get("Fire").addMonument(monument);
            }break;
            case "Earth":{
                Monument monument=new EarthMonument(tokens[2],Integer.parseInt(tokens[3]));
                this.nations.get("Earth").addMonument(monument);
            }break;

        }
    }
    public void statusNation(String nation){
        System.out.printf("%s Nation%n",nation);
        this.nations.get(nation).printStatus();
    }
    public void quit(){
        int count=0;
        for (String warIssue : warIssues) {
            count++;
            System.out.printf("War %d issued by %s%n",count,warIssue);
        }
    }
}
