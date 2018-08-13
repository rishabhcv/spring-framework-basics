package com.esp.springintro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.esp.scope.PersonDao;

@SpringBootApplication
@ComponentScan(basePackages= {"com.esp.scope"})
public class SpringScopeApplication {

	private static Logger log = LoggerFactory.getLogger(SpringScopeApplication.class);

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringScopeApplication.class, args);
		PersonDao personDao = ctx.getBean(PersonDao.class);
		PersonDao personDao1 = ctx.getBean(PersonDao.class);

		log.info("{}", personDao);
		log.info("{}", personDao.getJdbcConnection());
		log.info("{}", personDao1);
		log.info("{}", personDao1.getJdbcConnection());
	}
}
