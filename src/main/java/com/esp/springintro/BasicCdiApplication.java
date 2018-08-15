package com.esp.springintro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.esp.algo.BinarySearchImpl;
import com.esp.cdi.CdiBusiness;

@SpringBootApplication
@ComponentScan(basePackages= {"com.esp.cdi"})
public class BasicCdiApplication {

	private static Logger log = LoggerFactory.getLogger(BasicCdiApplication.class);
	
	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BasicCdiApplication.class, args);
		CdiBusiness cdi = ctx.getBean(CdiBusiness.class);
		log.info("{} - {}", cdi, cdi.getDummyDao());
	}
}
