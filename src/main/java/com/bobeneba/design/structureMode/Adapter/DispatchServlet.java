package com.bobeneba.design.structureMode.Adapter;

import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: DispatchServlet
 * @Description: 接口适配mvc
 * @Author: bobeneba
 * @Date 2022/4/8
 * @Version 1.0
 */

public class DispatchServlet {
    public  static List<HandlerAdapter> handlerAdapters = new ArrayList<HandlerAdapter>();

    DispatchServlet(){
        handlerAdapters.add(new HttpHandlerAdapter());
        handlerAdapters.add(new SimpleHandlerAdapter());
        handlerAdapters.add(new AnnotationHandlerAdapter());
    }

    public void doDispatch(){
        HttpController httpController = new HttpController();
        HandlerAdapter handlerAdapter = getHandler(httpController);
        if(handlerAdapter!=null){
            handlerAdapter.handle(httpController);
        }
    }
    public HandlerAdapter getHandler(Controller controller){
        for(HandlerAdapter handlerAdapter: handlerAdapters){
            if(handlerAdapter.supports(controller)){
                return handlerAdapter;
            }
        }
        return null;
    }

    public static void main(String[] args){
        new DispatchServlet().doDispatch();
    }



}

interface Controller{

}

class HttpController implements Controller{
    public void doHttp(){
        System.out.println("http");
    }
}
class SimpleController implements Controller{
    public void doSimple() {
        System.out.println("simple");
    }
}

class AnnotationController implements Controller{
    public void doAnnotation() {
        System.out.println("annotation");
    }
}

class OtherController implements Controller{
    public void doOther() {
        System.out.println("other");
    }
}

 interface HandlerAdapter{
    public boolean supports(Object handler);
    public  void handle(Object handler);

}

class SimpleHandlerAdapter implements HandlerAdapter{
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof SimpleController);
    }
    @Override
    public void handle(Object handler) {
        ((SimpleController) handler).doSimple();
    }
}


class HttpHandlerAdapter implements HandlerAdapter{//适配器
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof HttpController);
    }
    @Override
    public void handle(Object handler) {
        ((HttpController)handler).doHttp();
    }
}

class AnnotationHandlerAdapter implements HandlerAdapter{//适配器
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof AnnotationController);
    }
    @Override
    public void handle(Object handler) {
        ((AnnotationController)handler).doAnnotation();
    }
}

