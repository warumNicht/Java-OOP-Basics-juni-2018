package _1_ClassBox;

public class Box {
    private double lenght;
    private  double width;
    private double height;

    public Box(double lenght, double width, double height) {
        this.lenght = lenght;
        this.width = width;
        this.height = height;
    }

    public double getSurfaceArea(){
        return height*2*(lenght+width)+2*lenght*width;
    }
    public  double getLateralSurface(){
        return height*2*(lenght+width);
    }

    public double getVolume() {
        return height*width*lenght;
    }
}
