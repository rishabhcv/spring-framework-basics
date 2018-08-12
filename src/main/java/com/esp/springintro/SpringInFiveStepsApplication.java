package com.esp.springintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.esp.algo.BinarySearchImpl;

@SpringBootApplication
@ComponentScan(basePackages= {"com.esp.algo"})
public class SpringInFiveStepsApplication {
	
	//What are the beans? Annotate using @Component
	//What are the dependencies of a bean? Annotate using @Autowired
	//Where to look for the dependencies? Annotate using @ComponentScan
	//If the dependencies are in the same package as the Application class, which is highly unlikely,
	//then, we don't need to add the @ComponentScan annotation.

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringInFiveStepsApplication.class, args);
		BinarySearchImpl binarySearch = ctx.getBean(BinarySearchImpl.class);
		int result = binarySearch.search(new int[] {1, 5, 7}, 5);
		System.out.println(result);	
	}
}
