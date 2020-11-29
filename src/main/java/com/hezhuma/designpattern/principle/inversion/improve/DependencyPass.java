package com.hezhuma.designpattern.principle.inversion.improve;

/**
 * @program: design-pattern
 * @Date: 2020/11/29 10:36 上午
 * @Author: HESHIXIAN
 * @Description:
 */
public class DependencyPass {

    public static void main(String[] args) {
        ChangHong changHong = new ChangHong();

        OpenAndClose openAndClose = new OpenAndClose();
        openAndClose.open(changHong);

        // 通过构造器进行依赖传递
        XiaoMi xiaoMi = new XiaoMi();
        OpenAndCloseConstr openAndCloseConstr = new OpenAndCloseConstr(xiaoMi);
        openAndCloseConstr.open();

        SanXing sanXing = new SanXing();
        OpenAndCloseSetter openAndCloseSetter = new OpenAndCloseSetter();
        openAndCloseSetter.setTv(sanXing);
        openAndCloseSetter.open();
    }

}

interface ITV {
    public void play();
}

/**
 * 方式1 通过接口传递实现依赖
 */
interface IOpenAndClose {
    public void open(ITV itv);
}

class ChangHong implements ITV {
    @Override
    public void play() {
        System.out.println("长虹电视机，打开");
    }
}
class OpenAndClose implements IOpenAndClose {
    @Override
    public void open(ITV itv) {
        itv.play();
    }
}


/**
 * 方式2: 通过构造方法依赖传递
 */
interface IOpenAndCloseConstr {
    public void open();
}

class XiaoMi implements ITV {
    @Override
    public void play() {
        System.out.println("小米电视机，打开");
    }
}
class OpenAndCloseConstr implements IOpenAndCloseConstr {
    public ITV itv;

    public OpenAndCloseConstr(ITV itv) {
        this.itv = itv;
    }

    @Override
    public void open() {
        this.itv.play();
    }
}


/**
 * 方式三 通过setter方法传递
 */
interface IOpenAndCloseSetter {
    void open();

    void setTv(ITV itv);
}

class OpenAndCloseSetter implements IOpenAndCloseSetter {
    private ITV itv;

    @Override
    public void open() {
        this.itv.play();
    }

    @Override
    public void setTv(ITV itv) {
        this.itv = itv;
    }
}

class SanXing implements ITV {

    @Override
    public void play() {
        System.out.println("三星电视机，打开");
    }
}



