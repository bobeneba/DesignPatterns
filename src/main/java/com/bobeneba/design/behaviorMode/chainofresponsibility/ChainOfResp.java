package com.bobeneba.design.behaviorMode.chainofresponsibility;

/**
 * @ClassName: ChainOfResp
 * @Description: 责任链模式
 * @Author: bobeneba
 * @Date 2022/4/11
 * @Version 1.0
 */

public class ChainOfResp {
    public static void main(String[] args) {
        //组装责任链
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();
        handler1.setNext(handler2);
        //提交请求
        handler1.handleRequest("");
    }
}

abstract class Handler{
    private Handler next;

    public  void setNext(Handler next){
        this.next = next;
    }

    public Handler getNext(){
        return next;
    }
    public abstract void handleRequest(String request);
}

class ConcreteHandler1 extends Handler{

    @Override
    public void handleRequest(String request) {
        if (request.equals("one")) {
            System.out.println("具体处理者1负责处理该请求！");
        } else {
            if (getNext() != null) {
                System.out.println("传递链2");
                getNext().handleRequest(request);

            } else {
                System.out.println("没有人处理该请求！");
            }
        }
    }
}

class ConcreteHandler2 extends Handler {
    public void handleRequest(String request) {
        if (request.equals("two")) {
            System.out.println("具体处理者2负责处理该请求！");
        } else {
            if (getNext() != null) {
                System.out.println("传递链2");
                getNext().handleRequest(request);
            } else {
                System.out.println("没有人处理该请求！");
            }
        }
    }
}
