package com.bobeneba.design.structureMode.Bridge;

/**
 * @ClassName: BridgeTest
 * @Description: 桥接模式
 * @Author: bobeneba
 * @Date 2022/4/8
 * @Version 1.0
 */

public class BridgeTest {
      public static void main(String[] args){
          Red red = new Red();
          Pen pen = new SmallPen(red);
          pen.draw("花");

      }

}
interface Color{
    void bepaint(String penTpye,String name);
}
class Red implements Color{

    @Override
    public void bepaint(String penTpye, String name) {
        System.out.println(penTpye+name+"红色");
    }
}


class Black implements Color{

    @Override
    public void bepaint(String penTpye, String name) {
        System.out.println(penTpye+name+"黑色");
    }
}

abstract class Pen{
    public Color color;
    public void setColor(Color color){
        this.color=color;
    }
    public abstract void draw(String name);
}

class SmallPen extends Pen{

    public SmallPen(Color color){
        this.color=color;
    }

    public void draw(String name){
        String penTpye ="小号毛笔";
        this.color.bepaint(penTpye,name);

    }
}

class BigPen extends Pen{

    public BigPen(Color color){
        this.color=color;
    }

    public void draw(String name){
        String penTpye ="大号毛笔";
        this.color.bepaint(penTpye,name);

    }
}