package com.bobeneba.design.structureMode.flyweight;

import java.util.HashMap;

/**
 * @ClassName: FlyweightTest
 * @Description: 享元模式
 * @Author: bobeneba
 * @Date 2022/4/8
 * @Version 1.0
 */

public class FlyweightTest {
    public static void main(String[] args){
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight a = flyweightFactory.getFlyweight("a");
        Flyweight a1 = flyweightFactory.getFlyweight("a");
        a.operation(new UnsharedFlyweight("a非共享1"));
        a.operation(new UnsharedFlyweight("a非共享1"));
        Flyweight b = flyweightFactory.getFlyweight("b");
        a.operation(new UnsharedFlyweight("b非共享1"));
        a.operation(new UnsharedFlyweight("b非共享2"));




    }


}

class UnsharedFlyweight{
    private String info;

    public UnsharedFlyweight(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

interface Flyweight{
    public void operation(UnsharedFlyweight state);
}

class ConcreteFlyweight implements Flyweight{

    private String key;

    public ConcreteFlyweight(String key) {
        this.key = key;
        System.out.println("具体享元" + key + "被创建！");
    }

    @Override
    public void operation(UnsharedFlyweight state) {
        System.out.print("具体享元" + key + "被调用，");
        System.out.println("非享元信息是:" + state.getInfo());
    }
}

class FlyweightFactory{
      private HashMap<String,Flyweight> flyweights= new HashMap<String,Flyweight>();
      public Flyweight getFlyweight(String key){
          Flyweight flyweight = this.flyweights.get(key);
          if(flyweight !=null){
              System.out.println("具体享元" + key + "已经存在，被成功获取！");
          }else {
              flyweight = new ConcreteFlyweight(key);
              flyweights.put(key,flyweight);
          }
          return flyweight;
      }

}