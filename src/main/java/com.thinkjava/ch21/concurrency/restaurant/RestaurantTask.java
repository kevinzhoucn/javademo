//: com.thinkjava.ch21.concurrency.restaurant/RestaurantTask.java

package com.thinkjava.ch21.concurrency.restaurant;

/**
 * ===Start
 * RestaurantTest 测试 Restaurant 工作正常
 * End===
 * @author kevin.zhou
 * @version 1.0
 * @date 2016-08-24
 */

import com.thinkjava.ch21.concurrency.ITask;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import static com.kevinking.util.sprinttool.KeSprint.*;

@Component("restaurantTask")
public class RestaurantTask implements ITask {
    @Autowired
    private Restaurant restaurant;

    @Override
    public void runTask() {
        sprintlnGreen("Restaurant Task: Start");
        restaurant.startTask();
        sprintlnGreen("Restaurant Task: End");
    }
}