package com.esp.algo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class BinarySearchImpl implements SearchAlgorithm{
	
	Logger log = LoggerFactory.getLogger(BinarySearchImpl.class);
	
	@Autowired
	@Qualifier("quick")
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

	@Override
	public int search(int[] numbers, int searchNo) {
		System.out.println(sortAlgo);
		int[] sortedNumbers = sortAlgo.sort(numbers);
		return 5;
	}
	
	

}
