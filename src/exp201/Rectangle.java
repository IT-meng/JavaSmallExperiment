package exp201;

import java.util.Scanner;

public class Rectangle implements Geometricinterface{
    private double width;
    private double height;
    @Override
    public double length() {
        double len=2.0*(width+height);
        System.out.println("矩形的周长为："+len);
        return  len;
    }

    @Override
    public double area() {
        double sum=width*height;
        System.out.println("矩形的面积为："+sum);
        return sum;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle() {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入矩形的详细信息：宽：");
        this.width=sc.nextDouble();
        System.out.println("请输入矩形的详细信息：高：");
        this.height=sc.nextDouble();
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



}
