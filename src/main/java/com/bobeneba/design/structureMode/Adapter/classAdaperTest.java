package com.bobeneba.design.structureMode.Adapter;

/**
 * @ClassName: classAdaperTest
 * @Description: 类适配器
 * @Author: bobeneba
 * @Date 2022/4/8
 * @Version 1.0
 */

public class classAdaperTest {
    public static void main(String[] args){
        Phone phone = new Phone();
        phone.charging(new VoltageAdapter());
    }

}
//目标接口
interface IVoltage5v{
    public int output5v();
}
//被适配者
 class Voltage220v{
    public int output220v(){
        int output = 220;
        System.out.println("电压"+output);
        return output;
    }
}

 class VoltageAdapter extends Voltage220v implements IVoltage5v{

     @Override
     public int output5v() {
         int src = output220v();
         int dst=src/44;
         System.out.println("电压"+dst);
         return dst;
     }
 }

 class Phone{
    public void charging(IVoltage5v iVoltage5v){
        System.out.println(iVoltage5v.output5v());
    }
 }


