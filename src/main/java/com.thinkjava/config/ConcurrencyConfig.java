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
@ComponentScan(basePackages="com.thinkjava.ch21.concurrency")
public class ConcurrencyConfig {
}