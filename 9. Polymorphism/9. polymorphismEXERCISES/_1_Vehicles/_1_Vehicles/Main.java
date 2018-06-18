package _1_Vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens=reader.readLine().split("\\s+");

        Car car=new Car(Double.parseDouble(tokens[1]) ,Double.parseDouble(tokens[2]) );
        tokens=reader.readLine().split("\\s+");

        Truck truck=new Truck(Double.parseDouble(tokens[1]) ,Double.parseDouble(tokens[2]));

        int n=Integer.parseInt(reader.readLine());

        for(int i=0; i<n; i++){
            tokens=reader.readLine().split("\\s+");

            if("Drive".equals(tokens[0])){
                double distance=Double.parseDouble(tokens[2]);
                if("Car".equals(tokens[1])){
                    car.drive(distance);
                }else {
                    truck.drive(distance);
                }
            }else {
                double liters=Double.parseDouble(tokens[2]);
                if("Car".equals(tokens[1])){
                    car.reFuel(liters);
                }else {
                    truck.reFuel(liters);
                }
            }
        }


        System.out.printf("Car: %.2f%n",car.getFuel());
        System.out.printf("Truck: %.2f%n",truck.getFuel());

    }
}
