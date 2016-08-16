package demostate;

import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages="demostate")
@Component
public class GumballMachineConfig {
	public final int gumballNumber = 5;
}