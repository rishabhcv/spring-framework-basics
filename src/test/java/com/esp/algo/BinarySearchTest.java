package com.esp.algo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.esp.springintro.SpringBasicApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringBasicApplication.class)
public class BinarySearchTest {

	@Autowired
	BinarySearchImpl binarySearch;
	
	@Test
	public void testBinarySearch() {
		int result = binarySearch.search(new int[] {}, 5);
		assertEquals(5, result);
	}

}
