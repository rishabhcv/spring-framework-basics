package com.esp.cdi;

import javax.inject.Named;

@Named("dummy")
public class DummyDao {
	
	public int[] getData() {
		return new int[] {23, 45, 78};
	}
}
