package _2_ClassBoxDataValid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double lenght=Double.parseDouble(reader.readLine());
        double width=Double.parseDouble(reader.readLine());
        double height=Double.parseDouble(reader.readLine());

        try {
            Box box=new Box(lenght,width,height);
            System.out.printf("Surface Area - %.2f%n",box.getSurfaceArea());
            System.out.printf("Lateral Surface Area - %.2f%n",box.getLateralSurface());
            System.out.printf("Volume - %.2f%n",box.getVolume());
        }catch (IllegalArgumentException error){
            System.out.println(error.getMessage());
        }
    }
}
