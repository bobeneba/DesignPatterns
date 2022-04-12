package com.bobeneba.design.behaviorMode.visitor;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Client
 * @Description: 访问者模式
 * @Author: bobeneba
 * @Date 2022/4/12
 * @Version 1.0
 */

public class Client {


    public static void main(String[] args) {
    // 三件商品加入购物车
       List<Acceptable> products = Arrays.asList(
        new Candy("小黑兔奶糖", LocalDate.of(2018, 10, 1), 20.00f),
         new Wine("猫泰白酒", LocalDate.of(2017, 1, 1), 1000.00f),
         new Fruit("草莓", LocalDate.of(2018, 12, 26), 10.00f, 2.5f)
 );

  Visitor1 discountVisitor = new DiscountVisitor(LocalDate.of(2019, 1, 1));
  // 迭代购物车轮流结算
    for (Acceptable product : products) {
         product.accept(discountVisitor);
    }
    }
}

 abstract class Product {

     protected String name;// 品名
    protected LocalDate producedDate;// 生产日期
    protected float price;// 价格

   public Product(String name, LocalDate producedDate, float price) {
       this.name = name;
      this.producedDate = producedDate;
        this.price = price;
   }

   public String getName() {
       return name;
  }

   public void setName(String name) {
       this.name = name;
   }

 public LocalDate getProducedDate() {
      return producedDate;
    }

   public void setProducedDate(LocalDate producedDate) {
       this.producedDate = producedDate;
   }

   public float getPrice() {
      return price;
    }

  public void setPrice(float price) {
      this.price = price;
   }

}

 interface Visitor1 {// 访问者接口

   public void visit(Candy candy);// 糖果重载方法

  public void visit(Wine wine);// 酒类重载方法

 public void visit(Fruit fruit);// 水果重载方法

}

 class DiscountVisitor implements Visitor1 {
  private LocalDate billDate;

   public DiscountVisitor(LocalDate billDate) {
      this.billDate = billDate;
        System.out.println("结算日期：" + billDate);
 }

   @Override
 public void visit(Candy candy) {
   System.out.println("=====糖果【" + candy.getName() + "】打折后价格=====");
      float rate = 0;
     long days = billDate.toEpochDay() - candy.getProducedDate().toEpochDay();
        if (days > 180) {
        System.out.println("超过半年过期糖果，请勿食用！");
        } else {
          rate = 0.9f;
       }
      float discountPrice = candy.getPrice() * rate;
     System.out.println(NumberFormat.getCurrencyInstance().format(discountPrice));
  }

  @Override
 public void visit(Wine wine) {
      System.out.println("=====酒品【" + wine.getName() + "】无折扣价格=====");
     System.out.println(NumberFormat.getCurrencyInstance().format(wine.getPrice()));
  }

   @Override
 public void visit(Fruit fruit) {
      System.out.println("=====水果【" + fruit.getName() + "】打折后价格=====");
     float rate = 0;
      long days = billDate.toEpochDay() - fruit.getProducedDate().toEpochDay();
      if (days > 7) {
           System.out.println("￥0.00元（超过一周过期水果，请勿食用！）");
      } else if (days > 3) {
         rate = 0.5f;
      } else {
           rate = 1;
       }
        float discountPrice = fruit.getPrice();
      System.out.println(NumberFormat.getCurrencyInstance().format(discountPrice));
   }

}






 interface Acceptable {
    // 主动接受拜访者
   public void accept(Visitor1 visitor);

}

class Candy extends Product implements Acceptable{// 糖果类

   public Candy(String name, LocalDate producedDate, float price) {
        super(name, producedDate, price);
  }

   @Override
  public void accept(Visitor1 visitor) {
      visitor.visit(this);// 把自己交给拜访者。
  }

}


class Wine extends Product implements Acceptable{// 糖果类

    public Wine(String name, LocalDate producedDate, float price) {
        super(name, producedDate, price);
    }

    @Override
    public void accept(Visitor1 visitor) {
        visitor.visit(this);// 把自己交给拜访者。
    }

}


class Fruit extends Product implements Acceptable{// 糖果类

    public Fruit(String name, LocalDate producedDate, float v, float price) {
        super(name, producedDate, price);
    }

    @Override
    public void accept(Visitor1 visitor) {
        visitor.visit(this);// 把自己交给拜访者。
    }

}