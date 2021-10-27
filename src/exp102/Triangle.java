package exp102;

import static java.lang.Math.sqrt;

public class Triangle extends Graphics{
    private double first;
    private double second;
    private double third;

    public Triangle() {
    }

    public Triangle(double first, double second, double third) {

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
    public double area(){
        double p=0.5*(first+second+third);
        System.out.println("该三角形的面积为："+sqrt(p*(p-first)*(p-second)*(p-third)));
        return sqrt(p*(p-first)*(p-second)*(p-third));
    }

}
