package com.esp.springintro;

import com.esp.algo.BinarySearchImpl;
import com.esp.algo.BubbleSort;
import com.esp.algo.QuickSortAlgo;

public class SpringInFiveStepsApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringInFiveStepsApplication.class, args);
		BinarySearchImpl binarySearch = new BinarySearchImpl(new QuickSortAlgo());
		int result = binarySearch.search(new int[] {1, 5, 7}, 5);
		System.out.println(result);	
		BinarySearchImpl binarySearchTwo = new BinarySearchImpl(new BubbleSort());
		int res = binarySearchTwo.search(new int[] {1, 5, 7}, 5);
		System.out.println(res);
	}
}
