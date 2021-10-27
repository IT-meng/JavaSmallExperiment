package exp201;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Triangle implements Geometricinterface{
    private double first;
    private double second;
    private double third;

    public Triangle() {
        Scanner sc=new Scanner(System.in);
        double first,second,third;
        System.out.println("请分别输入三角形的第一二三边：");
        System.out.println("第一边：");
        first=sc.nextDouble();
        System.out.println("请输入第二边：");
        second=sc.nextDouble();
        System.out.println("请输入第三边：");
        third=sc.nextDouble();
        double temp=first>second?first :second;
        temp=temp>third?temp:third;
        if(temp==first)
        {
            if(second+third>first)
            {
                this.first = first;
                this.second = second;
                this.third = third;
            }else
            {
                System.out.println("不能构成三角形");
            }
        }
        else if(temp==second)
        {
            if(first+third>second){
                this.first = first;
                this.second = second;
                this.third = third;
            }else
            {
                System.out.println("不能构成三角形");
            }

        }else
        {
            if(first+second>third){
                this.first = first;
                this.second = second;
                this.third = third;
            }else
            {
                System.out.println("不能构成三角形");
            }

        }

    }

    public Triangle(double first, double second, double third) {

        this.first = first;
        this.second = second;
        this.third = third;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public void setSecond(double second) {
        this.second = second;
    }

    public void setThird(double third) {
        this.third = third;
    }

    public double getFirst() {
        return first;
    }

    public double getSecond() {
        return second;
    }

    public double getThird() {
        return third;
    }



    @Override
    public double length() {
       double len= first+second+third;
        System.out.println("三角形的周长为："+len);
        return len;
    }

    @Override
    public double area() {
        double p=0.5*(first+second+third);
        double sum=sqrt(p*(p-first)*(p-second)*(p-third));
        System.out.println("三角形的面积为："+sum);
        return sum;
    }
}
