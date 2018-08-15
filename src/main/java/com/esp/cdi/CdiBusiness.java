package com.esp.cdi;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class CdiBusiness {

	@Inject private @Named("dummy") DummyDao dummyDao;

	public DummyDao getDummyDao() {
		return dummyDao;
	}

	public void setDummyDao(DummyDao dummyDao) {
		this.dummyDao = dummyDao;
	}
	
	public int greatestInt() {
		int[] data = dummyDao.getData();
		int greatest= Integer.MIN_VALUE;
		for(int ar : data) {
			if(ar>greatest) {
				greatest=ar;
			}
		}
		return greatest;
	}

}
