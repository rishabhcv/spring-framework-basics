package com.esp.algo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
@Qualifier("bubble")
public class BubbleSort implements SortAlgo {

	@Override
	public int[] sort(int[] numbers) {
		// TODO Auto-generated method stub
		return numbers;
	}

}
