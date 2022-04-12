package com.bobeneba.design.behaviorMode.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MediatorPattern
 * @Description: 中介者
 * @Author: bobeneba
 * @Date 2022/4/11
 * @Version 1.0
 */

public class MediatorPattern {
    public static void main(String[] args) {
        Mediator md = new ConcreteMediator();
        Colleague c1, c2;
        c1 = new ConcreteColleaguel();
        c2 = new ConcreteColleague2();
        md.register(c1);
        md.register(c2);
        c1.send();
        System.out.println("-------------");
        c2.send();
    }
}




abstract class Mediator{
    public abstract void register(Colleague colleague);
    public abstract void reply(Colleague colleague);
}

class ConcreteMediator extends Mediator {
    private List<Colleague> colleagues = new ArrayList<>();


    @Override
    public void register(Colleague colleague) {
        if(!colleagues.contains(colleague)){
            colleagues.add(colleague);
            colleague.setMedium(this);
        }
    }

    @Override
    public void reply(Colleague colleague) {
            for(Colleague ob: colleagues){
                if(!ob.equals(colleague)){
                    ob.receive();
                }
            }
    }
}

abstract class Colleague{
    protected Mediator mediator;
    public void setMedium(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();
    public abstract  void send();

}

class ConcreteColleaguel extends Colleague{

    @Override
    public void receive() {
        System.out.println("具体同事类1收到请求。");
    }

    @Override
    public void send() {
        mediator.reply(this);
    }
}

//具体同事类
class ConcreteColleague2 extends Colleague {
    public void receive() {
        System.out.println("具体同事类2收到请求。");
    }

    public void send() {
        System.out.println("具体同事类2发出请求。");
        mediator.reply(this); //请中介者转发
    }
}