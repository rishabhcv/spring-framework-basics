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

}
