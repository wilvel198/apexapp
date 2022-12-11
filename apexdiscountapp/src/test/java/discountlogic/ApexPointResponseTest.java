package discountlogic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;
import com.apex.models.ResponseValue;
import org.junit.jupiter.api.Test;


class ApexPointResponseTest {

	@Test
	void testGetServiceStatus() {

		ResponseValue responseValue = Mockito.mock(ResponseValue.class);
		when(responseValue.getResponseInformation()).thenReturn("The Service is Up");
		assertEquals((responseValue.getResponseInformation()), "The Service is Up");

	}

	@Test
	void testCalculateDiscount() {
		ResponseValue responseValue = Mockito.mock(ResponseValue.class);
		when(responseValue.getResponseInformation()).thenReturn("The Service is Up");
		assertEquals((responseValue.getResponseInformation()), "The Service is Up");
	}

}
