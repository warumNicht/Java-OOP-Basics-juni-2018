import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class _5_SpeedRacing {
    public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(reader.readLine());

        List<Car> cars=new ArrayList<>();

        for(int i=0; i<n; i++){
            String[] tokens=reader.readLine().split("\\s+");
            Car curCar=new Car(tokens[0],Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]));
            cars.add(curCar);
        }

        String input=reader.readLine();

        while ("End".equals(input)==false){

            String[] tokens=input.split("\\s+");

            String curModel=tokens[1];
            double curKm=Double.parseDouble(tokens[2]);

            cars.stream()
                    .filter(x->x.getModel().equals(curModel))
                    .forEach(car->{
                        car.moveCar(curKm);
                    });
            input=reader.readLine();
        }

        for (Car car : cars) {
            DecimalFormat df=new DecimalFormat("#.###");
            String disFin=df.format(car.getDistance());
            System.out.printf("%s %.2f %s%n",
                    car.getModel(),car.getFuelAmount(),disFin);
        }

    }
}
class Car{

    String model;
    double fuelAmount;
    double fuelCost;
    double distance;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
    }

    public void moveCar(double kilometers){
        double verbrauchtesBenzin=this.getFuelCost()*kilometers;

        if(verbrauchtesBenzin>this.getFuelAmount()){
            System.out.println("Insufficient fuel for the drive");
        }else {
            this.setFuelAmount(this.getFuelAmount()-verbrauchtesBenzin);
            this.distance+=kilometers;
        }
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public double getDistance() {
        return distance;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
