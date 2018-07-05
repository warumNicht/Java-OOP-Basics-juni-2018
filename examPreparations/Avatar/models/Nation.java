package Avatar.models;

import Avatar.models.Benders.Bender;
import Avatar.models.Monuments.Monument;

import java.util.ArrayList;
import java.util.List;

public class Nation {
    private List<Bender> benders;
    private  List<Monument> monuments;

    public Nation() {
        this.benders = new ArrayList<>();
        this.monuments = new ArrayList<>();
    }

    protected List<Bender> getBenders() {
        return benders;
    }

    protected List<Monument> getMonuments() {
        return monuments;
    }

    public double calculatePower(){
        double power=0;
        for (Bender bender : this.getBenders()) {
            power+=bender.calculatePower();
        }
        return power;
    }
    public int calculateAffinity(){
        int affinity=0;
        for (Monument monument : this.getMonuments()) {
            affinity+=monument.getAffinity();
        }
        return affinity;
    }
    public double calculateTotalPower(){
        double total=0;
        double power=this.calculatePower();
        int affinitySum=this.calculateAffinity();
        total=power+power*(affinitySum/100.0);
        return total;
    }
    public  void clear(){
        this.benders.clear();
        this.monuments.clear();
    }
    public void addBender(Bender bender){
        this.benders.add(bender);
    }
    public void addMonument(Monument monument){
        this.monuments.add(monument);
    }
    public void printStatus(){
        StringBuilder res=new StringBuilder();
        if(this.getBenders().isEmpty()){
            res.append("Benders: None\n");
        }else {
            res.append("Benders:\n");
            for (Bender bender : this.getBenders()) {
                res.append(bender.toString());
            }
        }
        if(this.getMonuments().isEmpty()){
            res.append("Monuments: None\n");
        }else {
            res.append("Monuments:\n");
            for (Monument monument : this.getMonuments()) {
                res.append(monument.toString());
            }
        }
        System.out.print(res);
    }

}
