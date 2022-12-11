package com.apex.models;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class ResponseValueTest {

	
	
	@Test
	void testGetResponseInformation() {

	   ResponseValue responseValue = Mockito.mock(ResponseValue.class);
		
		when(responseValue.getResponseInformation()).thenReturn("System is Up");
		assertEquals(responseValue.getResponseInformation(),"System is Up");
	}


}
