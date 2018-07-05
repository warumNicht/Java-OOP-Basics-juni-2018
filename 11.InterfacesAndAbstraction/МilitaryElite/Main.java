package МilitaryElite;

import МilitaryElite.interfaces.ICommando;
import МilitaryElite.interfaces.ISpecialisedSoldier;
import МilitaryElite.models.Mission;
import МilitaryElite.models.Repair;
import МilitaryElite.models.soldiers.Privates.Commando;
import МilitaryElite.models.soldiers.Privates.Engineer;
import МilitaryElite.models.soldiers.Privates.LeutenantGeneral;
import МilitaryElite.models.soldiers.Privates.Private;
import МilitaryElite.models.soldiers.Spy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer,Private> privates=new HashMap<>();

        String input=reader.readLine();
        while ("End".equals(input)==false){
            String[]tokens=input.split("\\s+");
            int id=Integer.parseInt(tokens[1]);
            String firstName=tokens[2];
            String lastName=tokens[3];
            Double salary=Double.parseDouble(tokens[4]);
            switch (tokens[0]){
                case "Private":{
                    Private curr=new Private(id, firstName,lastName,salary);
                    privates.put(id,curr);
                    System.out.println(curr.toString());
                }break;
                case "Commando":{
                    ICommando com=new Commando(id,firstName,lastName,salary,tokens[5]);
                    if(com.validateCorps(tokens[5])){
                        if(tokens.length>6){
                            for(int i=6; i<tokens.length; i=i+2){
                                if(com.validateMission(tokens[i+1])){
                                    Mission mission=new Mission(tokens[i],tokens[i+1]);
                                    com.getMissions().add(mission);
                                }
                            }
                        }
                        System.out.print(com.toString());
                    }
                }break;
                case "LeutenantGeneral":{
                    LeutenantGeneral leutGen=new LeutenantGeneral(id,firstName,lastName,salary);
                    if(tokens.length>5){
                        for(int i=5; i<tokens.length; i++){
                            leutGen.getPrivates().add(Integer.parseInt(tokens[i]));
                        }
                    }
                    System.out.println(leutGen.toString());
                    leutGen.getPrivates().stream()
                            .sorted(Comparator.reverseOrder())
                            .forEach(x->{
                                System.out.println("  "+privates.get(x).toString());
                            });

                }break;
                case "Engineer":{
                    ISpecialisedSoldier engeneer=new Engineer(id,firstName,lastName,salary,tokens[5]);
                    if(engeneer.validateCorps(tokens[5])){
                        if(tokens.length>6){
                            for(int i=6; i<tokens.length; i+=2){
                                Repair repair=new Repair(tokens[i],Integer.parseInt(tokens[i+1]));
                                engeneer.getRepairs().add(repair);
                            }
                        }
                        System.out.print(engeneer.toString());
                    }

                }break;
                case "Spy":{
                    Spy spy=new Spy(id,firstName,lastName,tokens[4]);
                    System.out.println(spy.toString());

                }break;



            }


            input=reader.readLine();
        }


    }
}
