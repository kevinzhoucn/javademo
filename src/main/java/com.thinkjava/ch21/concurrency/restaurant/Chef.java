//: com.thinkjava.ch21.concurrency.restaurant/Chef.java

package com.thinkjava.ch21.concurrency.restaurant;

/** 
 * ===开始
 * Chef类持有restaurant对象 拥有field count 材料是否消耗完
 * 获得自己对象的锁 判断restaurant meal不为空 则挂起等待waitPerson拿走食物
 * 为空或者收到信号后 判断count是否大于材料数目
 * 若材料消耗完毕 调用restaurant关闭所有任务
 * 若材料还有剩余 获得restaurant.waitPerson的锁 生产食物 通知waitPerson
 * 结束===
 * 
 * @author kevin.zhou
 * @version 1.0
 * @date 2018-08-24
 */

import java.util.concurrent.*;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class Chef implements Runnable {
    @Autowired
    private Restaurant restaurant;

    private int count = 0;

    @Override
    public void run() {
        try {
            while(!Thread.interrupted()) {
                synchronized(this) {
                    while(restaurant.meal != null) {
                        wait();
                    }
                }

                if(++count == 10) {
                    System.out.println("Chef MAX MEAL NUMBER!");
                    restaurant.shutdownTask();
                }

                synchronized(restaurant.waitPerson) {
                    restaurant.meal = new Meal(count);
                    restaurant.waitPerson.notifyAll();
                }
            }
        } catch(InterruptedException e) {
            System.out.println("Chef INTERRUPTED!");
        }
    }
}