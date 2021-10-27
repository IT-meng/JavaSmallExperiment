package exp201;

import java.util.Scanner;

public class Testexp201 {
    public static void main(String[] args) {
        int choice;
        Scanner sc=new Scanner(System.in);
        while(true){
            showMenu();
            choice=sc.nextInt();
            switch(choice){
                case 1:{
                    show(new Rectangle());
                    break;
                }
                case 2:{
                    show(new Triangle());
                    break;
                }
                case 0:{
                    return;

                }
            }
        }



    }
    public static void show(Geometricinterface geometric){
        geometric.length();
        geometric.area();
    }
    public  static void showMenu(){
        System.out.println("形状类型：");
        System.out.println("1、长方形");
        System.out.println("2、三角形");
        System.out.println("0、退出");
    }
}
