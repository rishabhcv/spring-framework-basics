package com.esp.springintro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.esp.algo.BinarySearchImpl;

@SpringBootApplication
@ComponentScan(basePackages= {"com.esp.algo"})
public class SpringBasicApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringBasicApplication.class, args);
		BinarySearchImpl binarySearch = ctx.getBean(BinarySearchImpl.class);
		System.out.println(binarySearch);
		BinarySearchImpl binarySearch1 = ctx.getBean(BinarySearchImpl.class);
		System.out.println(binarySearch1);
		System.out.println(binarySearch.getUri());
		int result = binarySearch.search(new int[] {1, 5, 7}, 5);
		System.out.println(result);	
	}
}
