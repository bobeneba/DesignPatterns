package com.bobeneba.design.structureMode.proxy;

/**
 * @ClassName: ProxyTest
 * @Description: 代理模式
 * @Author: bobeneba
 * @Date 2022/4/8
 * @Version 1.0
 */

public class ProxyTest {
    public static void main(String[] args){
        proxy proxy = new proxy();
        proxy.Request();

    }

}

interface Subject{
    void Request();
}

class RealSubject implements Subject{

    @Override
    public void Request() {
        System.out.println("访问真实的主题方法");
    }
}

class proxy implements Subject{

    private RealSubject realSubject;

    @Override
    public void Request() {
        if (realSubject==null){
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();

    }
    public void preRequest() {
        System.out.println("访问真实主题之前的预处理。");
    }
    public void postRequest() {
        System.out.println("访问真实主题之后的后续处理。");
    }
}