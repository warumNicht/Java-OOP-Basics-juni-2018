package Shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        setRadius(radius);
        calculatePerimeter();
        calculateArea();
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(this.radius*2*Math.PI);
    }

    @Override
    protected void calculateArea() {
        setArea(this.radius*this.radius*Math.PI);
    }

    public final Double getRadius() {
        return radius;
    }
}
