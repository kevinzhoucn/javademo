//: com.thinkjava.ch21.restaurant/Meal.java

package com.thinkjava.ch21.concurrency.restaurant;

/**
 * Restaurant 生产者消费者例子
 * Meal 类 包含食物的 订单orderNum
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-23
 */

public class Meal {
    private final int orderNum;
    public Meal(int orderNum) { this.orderNum = orderNum; }
    public String toString() { return "Meal " + orderNum; }
}