package com.hezhuma.designpattern.principle.singleresponsibility;

/**
 * @program: design-pattern
 * @Date: 2020/11/28 6:11 下午
 * @Author: HESHIXIAN
 * @Description:
 */
public class SingleResponsibility3 {

    public static void main(String[] args) {
        Vehicles vehicles = new Vehicles();
        vehicles.run("汽车");
        vehicles.runAir("飞机");
        vehicles.runWater("轮船");
    }
}

// 交通工具类
/**
 * 方式3分析
 * 1. 这种修改方法没有对原来的类做大的修改，只是增加方法
 * 2. 这里虽然没有在类这个级别上遵守单一职责原则，但是在方法级别上，仍然是遵守单一职责
 */
class Vehicles {

    public void run(String vehicle) {
        System.out.println(vehicle + "在公路上运行。。。");
    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + "在天空运行。。。");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + "在水中运行。。。");
    }

}
