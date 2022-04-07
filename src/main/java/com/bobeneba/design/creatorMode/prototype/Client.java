package com.bobeneba.design.creatorMode.prototype;

import java.util.ArrayList;

/**
 * @ClassName: Prototype
 * @Description: 原型模式
 * @Author: bobeneba
 * @Date 2022/4/7
 * @Version 1.0
 */

 class Prototype implements Cloneable{


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone() ;
    }
}

  class PrototypeDeep implements Cloneable {
    public ArrayList list = new ArrayList();
    public PrototypeDeep clone(){
        PrototypeDeep prototype = null;
        try{
            prototype = (PrototypeDeep)super.clone();
            prototype.list = (ArrayList) this.list.clone();

        }catch(CloneNotSupportedException e){
            e.printStackTrace();
        }
        return prototype;
    }
}



class ConcretePrototype extends Prototype{
    public void show(){
        System.out.println("浅拷贝原型模式实现类");
    }
}

class ConcretePrototypeDeep extends PrototypeDeep{
    public void show(){
        System.out.println("深拷贝原型模式实现类"+this.list.toString());
    }
}


public class Client{
    public static  void main(String[] args) throws CloneNotSupportedException {
         ConcretePrototype cp = new ConcretePrototype();
        ConcretePrototypeDeep cpdep = new ConcretePrototypeDeep();
        for(int i=0;i<2;i++){
             ConcretePrototype clone = (ConcretePrototype)cp.clone();
             clone.show();
         }
         for(int i=0;i<2;i++){
             ConcretePrototypeDeep clone = (ConcretePrototypeDeep) cpdep.clone();
             clone.show();
         }

    }

}
