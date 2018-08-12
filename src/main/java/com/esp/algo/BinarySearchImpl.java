package com.esp.algo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchImpl implements SearchAlgorithm{
	
	@Autowired
	private SortAlgo sortAlgo;
	
/*	@Autowired
	public BinarySearchImpl(SortAlgo sortAlgo) {
		this.sortAlgo = sortAlgo;
	}*/
	
/*	public void setSortAlgo(SortAlgo sortAlgo) {
		this.sortAlgo = sortAlgo;
	}*/

	@Override
	public int search(int[] numbers, int searchNo) {
		int[] sortedNumbers = sortAlgo.sort(numbers);
		return 5;
	}

}
