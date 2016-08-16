//: com.multithread.config/MultithreadConfig.java

package com.multithread.config;

/** Thinking in Java Example program.
 * Ch04 config for Spring injection to package com.multithread.ch04.
 * @author kevin.zhou
 * @author kevin.zhou@hotmail.co.uk
 * @version 1.0
 */

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages={"com.multithread.ch01", "com.multithread.ch04", 
							 "com.multithread.ch04.p413.service", "com.multithread.ch04.p413.extthread"})
public class MultithreadConfig {
}