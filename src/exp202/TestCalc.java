package exp202;

import java.util.Scanner;

public class TestCalc {
    public static void main(String[] args) {

            System.out.println("请输入合法的中缀表达式：");
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            Calculator calculator = new Calculator();
            System.out.println(calculator.calculate(str));

    }
}