package com.bobeneba.design.structureMode.component;

import java.util.ArrayList;

/**
 * @ClassName: ComponentTest
 * @Description: 组合模式
 * @Author: bobeneba
 * @Date 2022/4/11
 * @Version 1.0
 */

public class ComponentTest {
    public static void main(String[] args) {

        float s = 0;
        Bags BigBag, mediumBag, smallRedBag, smallWhiteBag;
        Goods sp;
        BigBag = new Bags("大袋子");
        mediumBag = new Bags("中袋子");
        smallRedBag = new Bags("红色小袋子");
        smallWhiteBag = new Bags("白色小袋子");

        sp = new Goods("婺源特产", 2, 7.9f);
        smallRedBag.add(sp);
        sp = new Goods("婺源地图", 1, 9.9f);
        smallRedBag.add(sp);

        sp = new Goods("韶关香菇", 2, 68);
        smallWhiteBag.add(sp);
        sp = new Goods("韶关红茶", 3, 180);
        smallWhiteBag.add(sp);

        sp = new Goods("景德镇瓷器", 1, 380);
        mediumBag.add(sp);

        mediumBag.add(smallRedBag);

        sp = new Goods("李宁牌运动鞋", 1, 198);

        BigBag.add(sp);
        BigBag.add(smallWhiteBag);
        //BigBag.add(mediumBag);

        System.out.println("您选购的商品有：");
        BigBag.show();

        s = BigBag.calculation();
        System.out.println("要支付的总价是：" + s + "元");
    }
}

//抽象构件
interface Articles{
    public float calculation();
    public void show();
}

class Goods implements Articles{

    private String name;
    private int quantity;
    private float price;

    public Goods(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public float calculation() {
        return quantity*price;
    }

    @Override
    public void show() {
        System.out.println(name + "(数量：" + quantity + "，单价：" + price + "元)");
    }
}

class Bags implements Articles{

    private String name;
    private ArrayList<Articles> bags =new ArrayList<Articles>();

    public Bags(String name) {
        this.name = name;

    }

    @Override
    public float calculation() {
        float s=0;
        for(Object object: bags){
            s +=((Articles)object).calculation();
        }
        return s;
    }

    @Override
    public void show() {
        for(Object object: bags){
            ((Articles)object).show();
        }
    }

    public void add(Articles a){
        bags.add(a);
    }
    public void remove(Articles c) {
        bags.remove(c);
    }
    public Articles getChild(int i) {
        return bags.get(i);
    }


}
