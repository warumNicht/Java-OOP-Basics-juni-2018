package Avatar;
import Avatar.models.WarManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        WarManager manager=new WarManager();

        String input=reader.readLine();

        while ("Quit".equals(input)==false){

            String[]tokens=input.split("\\s+");
            String nation=tokens[1];
            switch (tokens[0]){
                case "Bender":{
                   manager.addNewBender(input);
                }break;
                case "Monument":{
                    manager.addNewMonument(input);
                }break;
                case "Status":{
                    manager.statusNation(nation);
                }break;
                case "War":{
                    manager.war(nation);
                }break;
            }
            input=reader.readLine();
        }
        manager.quit();
    }
}
