package exp102;

public class Rectangle extends Graphics {
    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    public double area()
    {
        System.out.println("该长方形的面积为："+this.height*this.width);
        return this.height*this.width;
    }
}
