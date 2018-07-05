package SystemSplit;

import SystemSplit.models.ComponentManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ComponentManager manager=new ComponentManager();
        String input;

        while (true){
            if("System Split".equals(input=reader.readLine())){
                break;
            }
            String[] tokens=input.split("[()]|,\\s+");
            String hardName="";
            if(tokens.length>1)
                hardName=tokens[1];

            switch (tokens[0]){
                case "RegisterPowerHardware":{
                    manager.registerPowerHardware(hardName,Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]));

                }break;
                case "RegisterHeavyHardware":{
                    manager.registerHeavyHardware(hardName,Integer.parseInt(tokens[2]),Integer.parseInt(tokens[3]));
                }break;
                case "RegisterExpressSoftware":{
                    manager.registerExpressSoftware(hardName,tokens[2],Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
                }break;
                case "RegisterLightSoftware":{
                    manager.registerLightSoftware(hardName,tokens[2],Integer.parseInt(tokens[3]),Integer.parseInt(tokens[4]));
                }break;
                case "ReleaseSoftwareComponent":{
                    manager.releaseSoftwareComponent(hardName,tokens[2]);
                }break;
                case "Analyze":{
                    manager.analyze();
                }break;
                case "Dump":{
                    manager.dump(tokens[1]);
                }break;
                case "Restore":{
                    manager.restore(tokens[1]);
                }break;
                case "Destroy":{
                    manager.destroy(tokens[1]);
                }break;
                case "DumpAnalyze":{
                    manager.dumpAnalyze();
                }break;
            }

        }
        manager.systemSplit();

    }
}
