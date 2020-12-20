package com.hezhuma.designpattern.principle.liskov.improve;

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
        // 因为B类不再继承A类，因此调用者，不会再认为func1是求减法了
        System.out.println("11 + 3 = " + b.fuc1(11, 3));
        System.out.println("1 + 8 = " + b.fuc1(1, 8));
        System.out.println("11 + 3 + 9 = " + b.fuc2(11, 3));

        // 使用组合仍然可以使用A类中相关方法
        System.out.println("11 - 3" + b.fuc3(11, 3));
    }

}

// 创建一个更加基础的基类
class Base {
    // 把更加基础的方法和成员写到Base类中

}

class A extends Base{
    // 返回两个数的差
    public int fuc1(int num1, int num2) {
        return num1 - num2;
    }
}

// B继承了A
// 增加了一个新功能：完成两个数相加，然后和9求和
class B extends Base {

    private A a = new A();
    // 如果B需要使用A类的方法，使用组合关系

    public int fuc1(int num1, int num2) {
        return num1 + num2;
    }
    public int fuc2(int num1, int num2) {
        return fuc1(num1, num2) + 9;
    }

    public int fuc3(int num1, int num2) {
        return this.a.fuc1(num1, num2);
    }
}
