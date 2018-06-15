package _2_ClassBoxDataValid;

public class Box {
    private double lenght;
    private  double width;
    private double height;

    public Box(double lenght, double width, double height) {
        setLenght(lenght);
        setWidth(width);
        setHeight(height);
    }

    private void setLenght(double lenght) {
        if(lenght<=0){
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }else {
            this.lenght = lenght;
        }
    }
    private void setWidth(double width) {
        if(width<=0){
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }else {
            this.width = width;
        }
    }
    private void setHeight(double height) {
        if(height<=0){
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }else {
            this.height = height;
        }
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
