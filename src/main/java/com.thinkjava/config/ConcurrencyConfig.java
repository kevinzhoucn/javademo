//: com.thinkjava.config/ConcurrencyConfig.java

package com.thinkjava.config;

/** Thinking in Java Example program.
 * Ch04 config for Spring injection to package com.thinkjava.ch21.
 * @author kevin.zhou
 * @author kevin.zhou@hotmail.co.uk
 * @version 1.0
 */

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages={"com.thinkjava.ch21.concurrency", "com.thinkjava.ch21.concurrency.p213", 
                             "com.thinkjava.ch21.concurrency.garden", "com.thinkjava.ch21.concurrency.interrupt",
                             "com.thinkjava.ch21.cocurrency.waxomatic", "com.thinkjava.ch21.cocurrency.waxomatic.v2",
                             "com.thinkjava.ch21.cocurrency.waxomatic.exercise21",
                             "com.thinkjava.ch21.cocurrency.restaurant", "com.thinkjava.ch21.concurrency.liftoffv2"})
public class ConcurrencyConfig {
}