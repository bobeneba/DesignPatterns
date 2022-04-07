package com.bobeneba.design.creatorMode.FactoryMethod;

/**
 * @ClassName: AbstractFactoryTest
 * @Description: 抽象工厂
 * @Author: bobeneba
 * @Date 2022/4/7
 * @Version 1.0
 */

public class AbstractFactoryTest {
    public static void main(String[] args){
        Product a;
        AbstractFactory af;
        af = (AbstractFactory)ReadXML.getObject();
        a=af.newProduct();
        a.show();

    }
}
interface Product {
    public void show();
}
//具体产品1：实现抽象产品中的抽象方法
class ConcreteProduct1 implements Product {
    public void show() {
        System.out.println("具体产品1显示...");
    }
}
//具体产品2：实现抽象产品中的抽象方法
class ConcreteProduct2 implements Product {
    public void show() {
        System.out.println("具体产品2显示...");
    }
}
//抽象工厂：提供了厂品的生成方法
interface AbstractFactory {
    public Product newProduct();
}
//具体工厂1：实现了厂品的生成方法
class ConcreteFactory1 implements AbstractFactory {
    public Product newProduct() {
        System.out.println("具体工厂1生成-->具体产品1...");
        return new ConcreteProduct1();
    }
}
//具体工厂2：实现了厂品的生成方法
class ConcreteFactory2 implements AbstractFactory {
    public Product newProduct() {
        System.out.println("具体工厂2生成-->具体产品2...");
        return new ConcreteProduct2();
    }
}