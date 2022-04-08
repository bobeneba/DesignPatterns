package com.bobeneba.design.structureMode.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName: TargetProxy
 * @Description: 再次封装动态代理
 * @Author: bobeneba
 * @Date 2022/4/8
 * @Version 1.0
 */
public class TargetProxyTest {
    public static void main(String[] args){
        Target target= new TargetImp();
        target.exe();

        Target target1 =(Target) TargetProxy.bind(target);
        target1.exe();
    }
}


interface Target{
    public void exe();
}

class TargetImp implements Target{

    @Override
    public void exe() {
        System.out.println("接口 真实对象 执行方法");
    }
}

class TargetProxy implements InvocationHandler {
    private Object target;
    private TargetProxy(Object target){
        this.target= target;
    }

    public static Object bind(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TargetProxy(target));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke begin");
        return method.invoke(target, args);
    }
}

