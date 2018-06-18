package _2_VehiclesExtention;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens=reader.readLine().split("\\s+");

        Car car=new Car(Double.parseDouble(tokens[1]) ,Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]) );

        tokens=reader.readLine().split("\\s+");
        Truck truck=new Truck(Double.parseDouble(tokens[1]) ,Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));

        tokens=reader.readLine().split("\\s+");
        Bus bus=new Bus(Double.parseDouble(tokens[1]) ,Double.parseDouble(tokens[2]),Double.parseDouble(tokens[3]));

        int n=Integer.parseInt(reader.readLine());

        for(int i=0; i<n; i++){
            tokens=reader.readLine().split("\\s+");
            double param=Double.parseDouble(tokens[2]);
            switch (tokens[1]){
                case "Car":{
                    if("Drive".equals(tokens[0])){
                        car.drive(param);
                    }else {
                        car.reFuel(param);
                    }
                }break;
                case "Truck":{
                    if("Drive".equals(tokens[0])){
                        truck.drive(param);
                    }else {
                        truck.reFuel(param);
                    }
                }break;
                case "Bus":{
                    if("Drive".equals(tokens[0])){
                        bus.setConsumption(bus.getConsumption()+1.4);
                        bus.drive(param);
                        bus.setConsumption(bus.getConsumption()-1.4);
                    }else if("DriveEmpty".equals(tokens[0])){
                        bus.drive(param);
                    }else {
                        bus.reFuel(param);
                    }
                }break;
            }
        }


        System.out.printf("Car: %.2f%n",car.getFuel());
        System.out.printf("Truck: %.2f%n",truck.getFuel());
        System.out.printf("Bus: %.2f%n",bus.getFuel());

    }
}
