package com.esp.algo;

public class BinarySearchImpl implements SearchAlgorithm{
	
	private SortAlgo sortAlgo;
	
	public BinarySearchImpl(SortAlgo sortAlgo) {
		this.sortAlgo = sortAlgo;
	}

	@Override
	public int search(int[] numbers, int searchNo) {
		int[] sortedNumbers = sortAlgo.sort(numbers);
		return 5;
	}

}
