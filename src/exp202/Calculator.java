package exp202;

import java.util.Stack;

public class Calculator{
Calculator (){

}

    //接收一个合法的中缀表达式，并计算其结果
    public int calculate(String str) {
        if (str == null) return -999;
        //声明两个栈，一个操作数栈，一个运算符栈
        Stack<Integer> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();
       //扫描中缀表达式
        for (int i = 0; i < str.length(); i++) {
            //遇到数字字符将其转化为int类型的数值(有可能遇到两位以上的数字)
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                int sum = 0;
                while ((str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                    sum = sum * 10 + (str.charAt(i) - '0');
                    i++;
                    if(i==str.length())break;
                }
                i--;
                stk1.push(sum);
            } else {
                switch (str.charAt(i)) {
                    //如果扫描到加号，看运算符栈里的情况，如果运算符栈为空'+'直接入栈
                    case '+': {
                        int flag = 0;
                        if (stk2.isEmpty()) {
                            stk2.push(str.charAt(i));
                            flag = 1;
                        } else {
                //运算符栈不为空，弹出栈里优先级不低于'＋'的运算符('-','*','/')
                //每弹出一个运算符就从操作数栈里弹出两个操作数做计算，并将计算结果压入操作数栈中
                            while (!stk2.isEmpty()) {
                                char tem = stk2.peek();
                                if (tem == '+' || tem == '-' || tem == '*' || tem == '/') {
                                    stk2.pop();
                                    operate(tem, stk1);
                //弹栈的过程中遇到左括号，直接将'+'号入栈
                                } else if (tem == '(') {
                                    stk2.push(str.charAt(i));
                                    flag = 1;
                                    break;
                                }

                            }
                            //用flag来记录当前运算符是否入栈，如果经过上述操作当前运算符一直没有入栈
                            //则直接将当前运算符压入运算符栈中
                            if (flag == 0) {
                                stk2.push(str.charAt(i));
                            }
                        }
                        break;
                    }
                    //遇到'-'号执行同加号相同的流程
                    case '-': {
                        int flag = 0;
                        if (stk2.isEmpty()) {
                            stk2.push(str.charAt(i));
                            flag = 1;
                        } else {
                            while (!stk2.isEmpty()) {
                                char tem = stk2.peek();
                                if (tem == '-' || tem == '+' || tem == '*' || tem == '/') {
                                    stk2.pop();
                                    operate(tem, stk1);
                                } else if (tem == '(') {
                                    stk2.push(str.charAt(i));
                                    flag = 1;
                                    break;
                                }

                            }
                            if (flag == 0) {
                                stk2.push(str.charAt(i));
                            }
                        }
                        break;
                    }
                    //执行同加号类似的流程
                    case '*': {
                        int flag = 0;
                        if (stk2.isEmpty()) {
                            stk2.push(str.charAt(i));
                            flag = 1;
                        } else {
                            while (!stk2.isEmpty()) {
                                char tem = stk2.peek();
                                if (tem == '*' || tem == '/') {
                                    operate(tem, stk1);
                                    stk2.pop();
                                } else if (tem == '+' || tem == '-') {
                                    stk2.push(str.charAt(i));
                                    flag = 1;
                                    break;
                                } else if (tem == '(') {
                                    stk2.push(str.charAt(i));
                                    flag = 1;
                                    break;
                                }

                            }
                            if (flag == 0) {
                                stk2.push(str.charAt(i));
                            }

                        }
                        break;
                    }
                    //执行同加号类似的流程
                    case '/': {
                        int flag = 0;
                        if (stk2.isEmpty()) {
                            stk2.push(str.charAt(i));
                            flag = 1;
                        } else {
                            while (!stk2.isEmpty()) {
                                char tem = stk2.peek();
                                if (tem == '*' || tem == '/') {
                                    operate(tem, stk1);
                                    stk2.pop();
                                } else if (tem == '+' || tem == '-') {
                                    stk2.push(str.charAt(i));
                                    flag = 1;
                                    break;
                                } else if (tem == '(') {
                                    stk2.push(str.charAt(i));
                                    flag = 1;
                                    break;

                                }
                            }
                            if (flag == 0) {
                                stk2.push(str.charAt(i));
                            }
                        }

                        break;
                    }
                    //遇到左小括号直接压入运算符栈
                    case '(': {
                        stk2.push(str.charAt(i));
                        break;
                    }
                    //遇到右小括号依次弹出运算符栈中的元素
                    //每弹出一个运算符就从操作数栈中弹出两个数进行计算，并将计算结果压入操作数栈，直到遇到左小括号为止
                    case ')': {
                        char tem = stk2.peek();
                        while (tem != '(') {
                            operate(tem, stk1);
                            stk2.pop();
                            tem = stk2.peek();
                        }
                        stk2.pop();
                        break;
                    }
                    default: {
                        System.out.println("表达式不合法");
                        break;
                    }

                }
            }
        }
        //扫描完整个中缀表达式后，依次弹出运算符栈里的运算符并进行计算将计算结果压入操作数栈中
        while (!stk2.isEmpty()) {
            operate(stk2.peek(), stk1);
            stk2.pop();

        }
//操作数栈的栈顶元素就是中缀表达式的计算结果
        return stk1.peek();


    }

    //operate方法接受一个运算符和一个操作数栈，负责从操作数栈中弹出两个操作数做计算并将计算结果压入操作数栈中
    public void operate(char op, Stack<Integer> stk1) {
        switch (op) {
            case '+': {
                int tem1 = stk1.peek();
                stk1.pop();
                int tem2 = stk1.peek();
                stk1.pop();
                stk1.push(new Add().getResult(tem2,tem1));
                break;
            }
            case '-': {
                int tem1 = stk1.peek();
                stk1.pop();
                int tem2 = stk1.peek();
                stk1.pop();
                stk1.push(new Subtract().getResult(tem2,tem1));
                break;

            }
            case '*': {
                int tem1 = stk1.peek();
                stk1.pop();
                int tem2 = stk1.peek();
                stk1.pop();
                stk1.push(new Multiple().getResult(tem2,tem1));
                break;

            }
            case '/': {
                int tem1 = stk1.peek();
                stk1.pop();
                int tem2 = stk1.peek();
                stk1.pop();
                stk1.push(new Divide().getResult(tem2,tem1));
                break;
            }
        }
    }
}