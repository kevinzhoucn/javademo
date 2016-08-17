//: com.thinkjava.ch21.concurrency.garden/Count.java

package com.thinkjava.ch21.concurrency.garden;

/**
 * OrnamentalGarden Count for synchronized
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-18
 */

import java.util.concurrent.*;
import java.util.*;

public class Count {

    /**
     * 临界资源应该被设置为私有变量
     */
    private int count = 0;
    private Random rand = new Random(47);

    /**
     * Remove synchronized will see the fail
     */
    public synchronized int increment() {
        int temp = count;
        if(rand.nextBoolean()) {
            Thread.yield();
        }
        return (count = ++temp);
    }

    /**
     * 每个访问临界资源的方法都应该被同步
     */
    public synchronized int value() { return count; }
}