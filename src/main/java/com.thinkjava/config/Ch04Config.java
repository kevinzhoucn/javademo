//: com.thinkjava.config/Ch04Config.java

package com.thinkjava.config;

/** Thinking in Java Example program.
 * Ch04 config for Spring injection to package com.thinkjava.ch04.
 * @author kevin.zhou
 * @author kevin.zhou@hotmail.co.uk
 * @version 1.0
 */

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages="com.thinkjava.ch04")
public class Ch04Config {
}