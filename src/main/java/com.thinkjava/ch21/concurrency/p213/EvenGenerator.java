//: com.thinkjava.ch21.concurrency.p213/EvenGenerator.java

package com.thinkjava.ch21.concurrency.p213;

/**
 * EvenGenerator extends from IntGenerator
 * To generate int nubmber
 * @author keivn.zhou
 * @version 1.0
 * date 2016-08-17
 */

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component("EvenGenerator")
// @Component
public class EvenGenerator extends IntGenerator {
    /*
     * Field currentEvenValue
     */
    private int currentEvenValue = 0;

    /*
     * Implements IntGenerator next()
     */
    @Override
    // public synchronized int next() {
    public synchronized int next() {    
        ++currentEvenValue; // Danger point here
        // Thread.yield();
        ++currentEvenValue; 
        return currentEvenValue;
    } 

}///~: