package com.hezhuma.designpattern.principle.segregation.improve;

/**
 * @program: design-pattern
 * @Date: 2020/11/28 8:36 下午
 * @Author: HESHIXIAN
 * @Description:
 */
public class Segregation2 {

    public static void main(String[] args) {
        A a = new A();
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
        c.depend5(new D());
    }

}

interface Interface1 {
    void operation1();
}

interface Interface2 {
    void operation2();
    void operation3();
}

interface Interface3 {
    void operation4();
    void operation5();
}

class B implements Interface1, Interface2 {


    @Override
    public void operation1() {
        System.out.println("B 实现了 operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B 实现了 operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B 实现了 operation3");
    }
}

// A 类通过接口Interface1, Interface2 依赖（使用）B类，但是只会用到1、2、3方法
class A {
    public void depend1(Interface1 interface1) {
        interface1.operation1();
    }
    public void depend2(Interface2 interface2) {
        interface2.operation2();
    }
    public void depend3(Interface2 interface2) {
        interface2.operation3();
    }
}

// C 类通过接口Interface1, Interface3 依赖（使用）D类，但是只会用到1、4、5方法
class C {
    public void depend1(Interface1 interface1) {
        interface1.operation1();
    }
    public void depend4(Interface3 interface3) {
        interface3.operation4();
    }
    public void depend5(Interface3 interface3) {
        interface3.operation5();
    }
}

class D implements Interface1, Interface3 {

    @Override
    public void operation1() {
        System.out.println("D 实现了 operation1");
    }

    @Override
    public void operation4() {
        System.out.println("D 实现了 operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D 实现了 operation5");
    }
}
