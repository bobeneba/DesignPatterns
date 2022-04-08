package com.bobeneba.design.structureMode.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: Client
 * @Description: 动态代理模式
 * @Author: bobeneba
 * @Date 2022/4/8
 * @Version 1.0
 */

public class Client {
    public static void main(String[] args){
        MaotaiWine maotaiWine = new MaotaiWine();
        InvocationHandler counter = new counter(maotaiWine);

        wuliangyeWine wuliangyeWine = new wuliangyeWine();
        InvocationHandler counter1 = new counter(wuliangyeWine);

        SellWine o = (SellWine)Proxy.newProxyInstance(MaotaiWine.class.getClassLoader(), MaotaiWine.class.getInterfaces(), counter);
        SellWine o1 = (SellWine)Proxy.newProxyInstance(wuliangyeWine.getClass().getClassLoader(),wuliangyeWine.getClass().getInterfaces(),counter1 );
        o.saleWine();
        o1.saleWine();

        Huawei huawei = new Huawei();
        InvocationHandler counter2 = new counter(huawei);
        computer o2 = (computer)Proxy.newProxyInstance(huawei.getClass().getClassLoader(), huawei.getClass().getInterfaces(), counter2);
        o2.saleComputer();
    }
}

interface SellWine{
    void saleWine();
}

class MaotaiWine implements SellWine{

    @Override
    public void saleWine() {
        System.out.println("卖茅台酒");
    }
}

class wuliangyeWine implements SellWine{

    @Override
    public void saleWine() {
        System.out.println("卖五粮液酒");
    }
}

interface computer{
    public void saleComputer();
}

class Huawei implements computer{

    @Override
    public void saleComputer() {
        System.out.println("卖电脑");
    }
}

class counter implements InvocationHandler{

    //实现接口的类的对象
    private Object object;

    public counter(Object object){
        this.object=object;

    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类：柜台 包装方法开始 "+this.getClass().getSimpleName());
        method.invoke(object, args);
        System.out.println("代理类：包装方法结束");
        return null;
    }
}