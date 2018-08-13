package com.esp.algo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("quick")
public class QuickSortAlgo implements SortAlgo {
   
	@Override
	public int[] sort(int[] numbers) {
		return numbers;
	}
}
