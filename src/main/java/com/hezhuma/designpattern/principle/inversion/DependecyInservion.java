package com.hezhuma.designpattern.principle.inversion;

/**
 * @program: design-pattern
 * @Date: 2020/11/29 12:01 上午
 * @Author: HESHIXIAN
 * @Description:
 */
public class DependecyInservion {

    public static void main(String[] args) {

    }
}

class Email {
    public String getInfo() {
        return "电子邮件信息：hello world";
    }
}

// 完成Persion接受消息的功能

/**
 * 方式1分析
 * 1. 简单，比较容易想到
 * 2. 如果我们获取的对象是微信，短信等，则需要新增类，同时Person也要增加相应的接受方法
 * 3. 解决思路：引入一个抽象的接口IReceiver，表示接受者，这样Person类与接口发生依赖
 *    因为Email，WeiXin等等属于接收范围，他们各自实现IReceiver接口就OK，这样我们就符合依赖倒转原则
 */
class Person {
    public void receive(Email email) {
        System.out.println(email.getInfo());
    }
}
