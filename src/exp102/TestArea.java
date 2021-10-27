package exp102;

import exp102.Circle;

import java.util.Scanner;

public class TestArea {
    public static void showMenu(){
        System.out.println("形状类型：");
        System.out.println("1、长方形");
        System.out.println("2、圆形");
        System.out.println("3、三角形");
        System.out.println("0、退出");

    }
    public static void show(Graphics grap){
        grap.area();

    }

    public static void main(String[] args) {
        while(true)
        {
            showMenu();
            int choice;
            System.out.println("请输入选项(1/2/3/0)");
            Scanner sc=new Scanner(System.in);
           choice= sc.nextInt();
           switch(choice)
           {
               case 1:{
                   double width,height;
                   System.out.println("请输入长方形的详细信息：\n宽：");
                   width=sc.nextDouble();
                   System.out.println("高：");
                   height=sc.nextDouble();
                   show(new Rectangle(width,height));

                    break;

               }
               case 2:{
                   double r;
                   System.out.println("请输入圆形的详细信息：\n半径：");
                   r=sc.nextDouble();
                  show(new Circle(r));

                   break;


               }
               case 3:{
                   double first,second,third;
                   System.out.println("请输入三角形的详细信息：\n第一边：");
                  first=sc.nextDouble();
                   System.out.println("第二边：");
                   second=sc.nextDouble();
                   System.out.println("第三边：");
                   third=sc.nextDouble();
                 show(new Triangle(first,second,third));


                   break;
               }
               case 0:{
                   return;

               }
           }

        }

    }
}
