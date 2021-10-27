package exp102;

public class Circle extends Graphics{
    private double r;

    public Circle() {
    }

    public Circle(double r) {
        this.r = r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getR() {
        return r;
    }
    public double area(){
        System.out.println("该圆的面积为："+ 3.1416*r*r);
        return 3.1416*r*r;
    }

}
