package com.hezhuma.designpattern.principle.liskov;

/**
 * @program: design-pattern
 * @Date: 2020/12/20 上午10:24
 * @Author: HESHIXIAN
 * @Description:
 */
public class Liskov {

    public static void main(String[] args) {
        A a = new A();
        System.out.println("11 - 3 = " + a.fuc1(11, 3));
        System.out.println("1 - 8 = " + a.fuc1(1, 8));
        System.out.println("-----------------------");

        B b = new B();
        System.out.println("11 - 3 = " + b.fuc1(11, 3));
        System.out.println("1 - 8 = " + b.fuc1(1, 8));
        System.out.println("11 + 3 + 9 = " + b.fuc2(11, 3));
    }

}

class A {
    // 返回两个数的差
    public int fuc1(int num1, int num2) {
        return num1 - num2;
    }
}

// B继承了A
// 增加了一个新功能：完成两个数相加，然后和9求和
class B extends A {

    @Override
    public int fuc1(int num1, int num2) {
        return num1 + num2;
    }
    public int fuc2(int num1, int num2) {
        return fuc1(num1, num2) + 9;
    }
}
