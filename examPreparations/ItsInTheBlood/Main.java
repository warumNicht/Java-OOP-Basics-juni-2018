package ItsInTheBlood;

import ItsInTheBlood.models.HealthManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HealthManager manager=new HealthManager();

        String input=reader.readLine();

        while ("BEER IS COMING".equals(input)==false){

            String[]tokens=input.trim().split("\\s+");
            String name=tokens[1];
            String res=null;
            switch (tokens[0]){
                case "checkCondition":{
                    res=manager.checkCondition(name);

                }break;
                case "createOrganism":{
                    res=manager.createOrganism(name);
                }break;
                case "addCluster":{
                    res=manager.addCluster(name,tokens[2],Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));

                }break;
                case "addCell":{
                    res=manager.addCell(name,tokens[2],tokens[3],tokens[4],
                            Integer.parseInt(tokens[5]),Integer.parseInt(tokens[6]),Integer.parseInt(tokens[7]),Integer.parseInt(tokens[8]));
                }break;
                case "activateCluster":{
                    res=manager.activateCluster(name);

                }break;

            }
            if(res!=null){
                System.out.print(res);
            }
            input=reader.readLine();
        }

    }
}
