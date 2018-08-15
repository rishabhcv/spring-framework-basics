package com.esp.algo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
@PropertySource("classpath:app.properties")
public class BinarySearchImpl implements SearchAlgorithm{
	
	Logger log = LoggerFactory.getLogger(BinarySearchImpl.class);
	
	@Autowired
	private SortAlgo sortAlgo;
	
	@PostConstruct
	public void init() {
		log.info("init method called");
	}
	
	@PreDestroy
	public void destruct() {
		log.info("destruct method called");
	}
	
/*	@Autowired
	public BinarySearchImpl(SortAlgo sortAlgo) {
		this.sortAlgo = sortAlgo;
	}*/
	
/*	public void setSortAlgo(SortAlgo sortAlgo) {
		this.sortAlgo = sortAlgo;
	}*/
	
	@Value("${external.service.url}")
	private String url;
	
	public String getUri() {
		return this.url;
	}

	@Override
	public int search(int[] numbers, int searchNo) {
		System.out.println(sortAlgo);
		sortAlgo.sort(numbers);
		return 5;
	}
	
}
