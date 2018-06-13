import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _6_RawData {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(reader.readLine());

        List<Car2> cars=new ArrayList<>();

        for(int i=0; i<n; i++){

            String[]tokens=reader.readLine().split("\\s+");
            String model=tokens[0];
            int engineSpeed=Integer.parseInt(tokens[1]);
            int enginePower=Integer.parseInt(tokens[2]);
            int cargoWeight=Integer.parseInt(tokens[3]);
            String cargoType=tokens[4];
            double tire1Pressure=Double.parseDouble(tokens[5]);
            int tire1age=Integer.parseInt(tokens[6]);

            double tire2Pressure=Double.parseDouble(tokens[7]);
            int tire2age=Integer.parseInt(tokens[8]);

            double tire3Pressure=Double.parseDouble(tokens[9]);
            int tire3age=Integer.parseInt(tokens[10]);

            double tire4Pressure=Double.parseDouble(tokens[11]);
            int tire4age=Integer.parseInt(tokens[12]);

            Engine curEngine=new Engine(engineSpeed,enginePower);
            Cargo curCargo=new Cargo(cargoWeight,cargoType);

            Tire tire1=new Tire(tire1Pressure,tire1age);
            Tire tire2=new Tire(tire2Pressure,tire2age);
            Tire tire3=new Tire(tire3Pressure,tire3age);
            Tire tire4=new Tire(tire4Pressure,tire4age);

            Tire[] curTires=new Tire[]{tire1,tire2,tire3,tire4};

            Car2 curCar=new Car2(model,curEngine,curCargo,curTires);

            cars.add(curCar);
        }

        if("fragile".equals(reader.readLine())){

            cars.stream()
                    .filter(x->x.getCargo().getType().equals("fragile"))
                    .filter(y->{
                       return Arrays.stream(y.getTires()).anyMatch(t->t.getPressure()<1);
                    })
                    .forEach(car->{
                        System.out.println(car.getModel());
                    });


        }else {
            cars.stream()
                    .filter(x->x.getCargo().getType().equals("flamable")&&x.getEngine().getPower()>250)
                    .forEach(car-> System.out.println(car.getModel()));

        }
    }
}
class Car2{

    String model;
    Engine engine;
    Cargo cargo;
    Tire[] tires;

    public Car2(String model, Engine engine, Cargo cargo, Tire[] tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire[] getTires() {
        return tires;
    }
}
class Engine{
    int speed;
    int power;

    public Engine(int speed, int power) {
        this.speed = speed;
        this.power = power;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPower() {
        return power;
    }
}
class Cargo{
    int weight;
    String type;

    public Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }
}
class  Tire{
    double pressure;
    int age;

    public Tire(double pressure, int age) {
        this.pressure = pressure;
        this.age = age;
    }

    public double getPressure() {
        return pressure;
    }

    public int getAge() {
        return age;
    }
}
