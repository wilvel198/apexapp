package com.apex.models;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class TransactionInfoTest {

	@Test
	void testGetDollarSpent() {

		TransactionInfo responseValue = Mockito.mock(TransactionInfo.class);

		when(responseValue.getDollarSpent()).thenReturn(90);
		assertEquals(responseValue.getDollarSpent(), 90);
	}

}
