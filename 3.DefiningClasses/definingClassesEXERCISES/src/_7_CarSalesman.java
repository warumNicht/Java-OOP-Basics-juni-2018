import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class _7_CarSalesman {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(reader.readLine());

        List<Engine2> engines=new ArrayList<>();

        for(int i=0; i<n; i++){
            String[]tokens=reader.readLine().split("\\s+");

            String model=tokens[0];
            int power=Integer.parseInt(tokens[1]);

            Engine2 curEngine=new Engine2(model,power);

            if(tokens.length==3){
                if(Character.isDigit(tokens[2].charAt(0))){
                    curEngine.setDisplacement(Integer.parseInt(tokens[2]));
                }else {
                    curEngine.setEfficiency(tokens[2]);
                }
            }else if(tokens.length==4){
                curEngine.setDisplacement(Integer.parseInt(tokens[2]));
                curEngine.setEfficiency(tokens[3]);
            }
            engines.add(curEngine);
        }

        int m= Integer.parseInt(reader.readLine());

        List<Car3> cars=new ArrayList<>();

        for (int i = 0; i <m ; i++) {

            String[]tokens=reader.readLine().split("\\s+");

            String model=tokens[0];
            List<Engine2> curEng=engines.stream()
                    .filter(x->x.getModel().equals(tokens[1]))
                    .limit(1)
                    .collect(Collectors.toList());

            Car3 curCar=new Car3(model,curEng.get(0));

            if(tokens.length==3){
                if(Character.isDigit(tokens[2].charAt(0))){
                    curCar.setWeight(Integer.parseInt(tokens[2]));
                }else {
                    curCar.setColor(tokens[2]);
                }
            }else if(tokens.length==4){
                curCar.setWeight(Integer.parseInt(tokens[2]));
                curCar.setColor(tokens[3]);
            }

            cars.add(curCar);
        }

        for (Car3 car : cars) {
            car.printCar();
        }
    }
}
class Car3{

    String model;
    Engine2 engine;
    int weight;
    String color;

    public void printCar(){

        System.out.println(this.model+":");
        System.out.printf("%s:%n",this.engine.model);
        System.out.printf("Power: %d%n",this.engine.power);

        if(this.engine.displacement<=0){
            System.out.println("Displacement: n/a");
        }else {
            System.out.printf("Displacement: %d%n",this.engine.displacement);
        }
        System.out.printf("Efficiency: %s%n",this.engine.efficiency);

        if(this.weight<0){
            System.out.println("Weight: n/a");
        }else {
            System.out.printf("Weight: %d%n",this.weight);
        }
        System.out.printf("Color: %s%n",this.color);

    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car3(String model, Engine2 engine) {
        this.model = model;
        this.engine = engine;
        this.weight=-1;
        this.color="n/a";
    }
}
class Engine2{
    String model;
    int power;
    int displacement;
    String efficiency;

    public Engine2(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement=-1;
        this.efficiency="n/a";
    }

    public String getModel() {
        return model;
    }

    public int getPower() {
        return power;
    }

    public int getDisplacement() {
        return displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }
}
