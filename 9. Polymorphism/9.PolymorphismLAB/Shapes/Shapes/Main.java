package Shapes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Shape> shapes = new ArrayList<>();

        shapes.add(new Rectangle(4d, 4d));
        shapes.add(new Rectangle(5d, 5d));
        shapes.add((new Circle(2d)));
        shapes.add((new Circle(3d)));

        System.out.println("Area | Perimeter");

        for (Shape shape : shapes) {
            System.out.println(shape.getArea() + " | " + shape.getPerimeter());
        }
    }
}
