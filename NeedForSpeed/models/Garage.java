package NeedForSpeed.models;

import NeedForSpeed.models.Cars.Car;
import java.util.List;

public class Garage {
    private List<Car> parkedCars;

    public Garage(List<Car> parkedCars) {
        this.parkedCars = parkedCars;
    }

}
