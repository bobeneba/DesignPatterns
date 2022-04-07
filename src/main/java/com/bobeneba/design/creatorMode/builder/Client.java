package com.bobeneba.design.creatorMode.builder;



/**
 * @ClassName: Client
 * @Description: 建造者模式
 * @Author: bobeneba
 * @Date 2022/4/7
 * @Version 1.0
 */

public class Client {
    public static void main(String[] args){
        Builder builder = new  ConcreteBuilder();
        Director director= new Director(builder);
        Product product = director.construct();
        product.show();
    }
}

 class Product {
    private String partA;
    private String partB;
    private String partC;

    public void setPartA(String partA) {
        this.partA = partA;
        System.out.println("set partA ");
    }

    public void setPartB(String partB) {
        this.partB = partB;
        System.out.println("set partB ");
    }

    public void setPartC(String partC) {
        this.partC = partC;
        System.out.println("set partC ");
    }
    public void show() {
        //显示产品的特性
        System.out.println(partA.toString() + partB.toString() + partC.toString());
    }
 }

abstract class Builder{
    protected Product product = new Product();
    public abstract Builder buildPartA();
    public abstract Builder buildPartB();
    public abstract Builder buildPartC();

    //返回产品对象
    public Product build() {
        return product;
    }
}

 class ConcreteBuilder extends Builder{
     public Builder buildPartA() {
         product.setPartA("建造 PartA");
         return this;
     }
     public Builder buildPartB() {
         product.setPartB("建造 PartB");
         return this;
     }
     public Builder buildPartC() {
         product.setPartC("建造 PartC");
         return this;
     }
 }

 class Director{
    private Builder builder;
    public Director(Builder builder){
        this.builder=builder;
    }
    public Product construct(){

       builder = builder.buildPartB().buildPartC().buildPartA();
        return builder.build();
    }
 }