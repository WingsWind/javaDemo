package javaSE;

import java.util.Scanner;

/**
 * Created by futuration on 2019/7/29.
 */
public class hello_world {
    public static void main(String args[]) {
        System.out.println("hello world");
        StringBuilder sb = new StringBuilder("hello world");
        System.out.println(sb);
        System.out.println("=============");

        /**
         * 浮点数运算存在误差
         */
        double x = 1.0 / 10;
        double y = 1 - 9.0 / 10;
        System.out.println(x);
        System.out.println(y);

        /**
         * 浮点数4舍5入
         */
        double z = 2.6;
        int n = (int) (z = 0.5);
        System.out.println();

        /**
         * 字符串不可变
         */
        String s = "hello";
        String t = s;
        s = "world";
        System.out.println(t);

        /**
         * 输入输出
         */
//        Scanner sc = new Scanner(System.in);
//        System.out.print("请输入你上次考试成绩：");
//        int beforeScore = sc.nextInt();
//        System.out.print("请输入你这次考试成绩：");
//        int nowScore = sc.nextInt();
//        double answer = 100.0 * nowScore / beforeScore;
//        System.out.printf("你成绩提升了%.2f%%", answer-100);

        System.out.print("==========\n");
        Person p1 = new Person();
        Person p2 = new Person();
        Person p3 = new Person();
        Person p4 = new Person();
        int count =  Person.getCount();

        System.out.print(count);
    }
}
