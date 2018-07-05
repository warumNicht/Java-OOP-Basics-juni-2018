package kermen;

import kermen.models.City;
import kermen.models.homes.HomeFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        City kermen=new City();
        HomeFactory buildHome=new HomeFactory();

        String input=reader.readLine();
        int comCount=0;

        while ("Democracy".equals(input)==false){
            comCount++;

            if(input.contains("(")){
                String[]tokens=input.split("\\)[^()]+\\(|\\(|\\)");
                kermen.getHomes().add(buildHome.createHome(tokens));
            }

            if(comCount%3==0){
                kermen.receiveSalary();
            }
            if(input.equals("EVN")){
                DecimalFormat df=new DecimalFormat("#.##############");
                String finForm=df.format(kermen.totalConsumption());
                if(finForm.contains(".")==false){
                    finForm+=".0";
                }
                System.out.println(String.format("Total consumption: %s",finForm));

            }else if(input.equals("EVN bill")){
                kermen.payEl();
                kermen.actualize();

            }



            input=reader.readLine();
        }

        System.out.println(String.format("Total population: %d",kermen.totalPopulation()));

    }
}
