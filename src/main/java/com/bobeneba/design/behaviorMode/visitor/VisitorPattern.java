package com.bobeneba.design.behaviorMode.visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: VisitorPattern
 * @Description: 访问者模式
 * @Author: bobeneba
 * @Date 2022/4/12
 * @Version 1.0
 */

public class VisitorPattern {

    public static void main(String[] args) {
        ObjectStructure os = new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        Visitor visitor = new ConcreteVisitorA();
        os.accept(visitor);
        System.out.println("------------------------");
        visitor = new ConcreteVisitorB();
        os.accept(visitor);
    }
}

class ObjectStructure{
    private List<Element> list = new ArrayList<>();
    public void accept(Visitor visitor){
        Iterator<Element> i = list.iterator();
        while (i.hasNext()){
            ((Element)i.next()).accept(visitor);
        }

    }

    public void add(Element element) {
        list.add(element);
    }
    public void remove(Element element) {
        list.remove(element);
    }
}



interface Visitor{
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}

class ConcreteVisitorA implements Visitor {
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者A访问-->" + element.operationA());
    }
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者A访问-->" + element.operationB());
    }
}

//具体访问者B类
class ConcreteVisitorB implements Visitor {
    public void visit(ConcreteElementA element) {
        System.out.println("具体访问者B访问-->" + element.operationA());
    }
    public void visit(ConcreteElementB element) {
        System.out.println("具体访问者B访问-->" + element.operationB());
    }
}


interface Element {
    void accept(Visitor visitor);
}

class ConcreteElementA implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public String operationA() {
        return "具体元素A的操作。";
    }
}

//具体元素B类
class ConcreteElementB implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    public String operationB() {
        return "具体元素B的操作。";
    }
}