package com.esp.algo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.esp.cdi.CdiBusiness;
import com.esp.cdi.DummyDao;

@RunWith(MockitoJUnitRunner.class)
public class BasicCdiAppTest {
	
    @InjectMocks
	CdiBusiness cdiBean;
	
	@Mock
	DummyDao dummyBean;
	
	@Test
	public void greaterCase() {
		Mockito.when(dummyBean.getData()).thenReturn(new int[] {2,5,6});
		assertEquals(6, cdiBean.greatestInt());
	}
	
	@Test
	public void nullCase() {
		Mockito.when(dummyBean.getData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, cdiBean.greatestInt());
	}
	
	@Test
	public void equalsCase() {
		Mockito.when(dummyBean.getData()).thenReturn(new int[] {2, 2});
		assertEquals(2, cdiBean.greatestInt());
	}

}
