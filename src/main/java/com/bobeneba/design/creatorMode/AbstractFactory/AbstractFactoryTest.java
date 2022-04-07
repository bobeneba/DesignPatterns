package com.bobeneba.design.creatorMode.AbstractFactory;

import com.bobeneba.design.creatorMode.AbstractFactory.ReadXML;


/**
 * @ClassName: AbstractFactoryTest
 * @Description: 抽象工厂
 * @Author: bobeneba
 * @Date 2022/4/7
 * @Version 1.0
 */

public class AbstractFactoryTest {
    public static void main(String[] args){
        ProductA a;
        ProductB b;
        AbstractFactory af;
        af = (AbstractFactory) ReadXML.getObject();
        a=af.newProduct();
        b=af.newProductB();
        a.show();
        b.show();

    }
}

interface ProductA {
    public void show();
}

interface ProductB {
    public void show();
}
//具体产品1：实现抽象产品中的抽象方法
class ConcreteProduct1 implements ProductA {
    public void show() {
        System.out.println("A1类冰箱具体产品1显示...");
    }
}

//具体产品2：实现抽象产品中的抽象方法
class ConcreteProduct2 implements ProductA {
    public void show() {
        System.out.println("A2类具体产品2显示...");
    }
}

//具体产品1：实现抽象产品中的抽象方法
class ConcreteProductB1 implements ProductB {
    public void show() {
        System.out.println("B1类冰箱具体产品1显示...");
    }
}

//具体产品2：实现抽象产品中的抽象方法
class ConcreteProductB2 implements ProductB {
    public void show() {
        System.out.println("B2类具体产品2显示...");
    }
}



//抽象工厂：提供了厂品的生成方法
interface AbstractFactory {
    public ProductA newProduct();
    public ProductB newProductB();
}

//具体工厂1：实现了厂品的生成方法
class ConcreteFactory1 implements AbstractFactory {
    public ProductA newProduct() {
        System.out.println("具体工厂1生成-->具体产品A1...");
        return new ConcreteProduct1();
    }
    public ProductB newProductB() {
        System.out.println("具体工厂1B生成-->具体产品B1...");
        return new ConcreteProductB1();
    }
}

//具体工厂2：实现了厂品的生成方法
class ConcreteFactory2 implements AbstractFactory {
    public ProductA newProduct() {
        System.out.println("具体工厂2生成-->具体产品A2...");
        return new ConcreteProduct2();
    }

    public ProductB newProductB() {
        System.out.println("具体工厂2生成-->具体产品B2...");
        return new ConcreteProductB2();
    }
}