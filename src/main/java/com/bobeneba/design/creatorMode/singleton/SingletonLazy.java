package com.bobeneba.design.creatorMode.singleton;

/**
 * @ClassName: SingletonLazy
 * @Description: 单例懒加载模式
 * @Author: bobeneba
 * @Date 2022/4/7
 * @Version 1.0
 */

public class SingletonLazy {

    public static void main(String[] args){
        President instance = President.getInstance();
        President instance1 =President.getInstance();
        if (instance == instance1) {
            System.out.println("他们是同一人！");
        } else {
            System.out.println("他们不是同一人！");
        }
    }

}

class President {
    private static volatile President instance =null;

    private President(){
        System.out.println("产生一个总统");
    }
    static public synchronized President getInstance(){
        if(instance==null){
            instance = new President();
        }
        return instance;
    }

}