//: com.thinkjava.ch21.concurrency.garden/Entrance.java
package com.thinkjava.ch21.concurrency.garden;

/**
 * 模拟公园入口的程序
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-18
 */

import java.util.concurrent.*;
import java.util.*;

public class Entrance implements Runnable {
    /**
     * 一个静态的计数器变量
     * 调用increment() 增加人员总量
     */
    private static Count count = new Count();

    /**
     * 静态的所有入口列表
     */
    private static List<Entrance> entrances = new ArrayList<Entrance>();

    /**
     * 内部变量记录线程调用了多少次
     */
    private int number = 0;

    /**
     * 不可改变id 记录线程的数目值
     */
    private final int id;

    /**
     * 可见性变量 canceled 线程间可见
     */
    private static volatile boolean canceled = false;

    /**
     * 原子操作 线程是否取消
     */
    public static void cancel() { canceled = true; }

    public Entrance(int id) {
        this.id = id;

        // 任务存入任务列表，避免垃圾回收
        entrances.add(this);
    }

    /**
     * 重写 run() 方法，如果标志位没有取消
     * 继续运行，运行次数加 1
     */
    @Override
    public void run() {
        while(!canceled) {
            synchronized(this) {
                ++number;
            }
            System.out.println(this + " Total: " + count.increment());
            try {
                TimeUnit.MILLISECONDS.sleep(100);                
            } catch (InterruptedException e) {
                System.out.println("sleep interrupted");
            }
        }
        System.out.println("Stopping: " + this);
    }

    /**
     * 返回临界值 number
     */
    public synchronized int getValue() { return number; }

    @Override
    public String toString() {
        return "Entrance " + id + ": " + getValue();
    }

    public static int getTotalCount() {
        return count.value();
    }

    public static int sumEntrances() {
        int sum = 0;
        for(Entrance entrance : entrances) {
            sum += entrance.getValue();
        }
        return sum;
    }
}