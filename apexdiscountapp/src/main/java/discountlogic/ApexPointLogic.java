package discountlogic;

import org.springframework.stereotype.Component;

import com.apex.models.ResponseValue;

@Component
public class ApexPointLogic {

	public ResponseValue getServiceStatus() {
		ResponseValue response2Call = new ResponseValue();

		response2Call.setResponseInformation("The Service is Up");

		return response2Call;
	}

	public ResponseValue calculateDiscount(int spentVal) {

		ResponseValue response2Call = new ResponseValue();
		int pointCount = 0;

		pointCount = calculatePoints(spentVal);
		response2Call.setResponseInformation("Calculated Points :" + pointCount);

		return response2Call;

	}

	// logic to calculate points
	private static int calculatePoints(int val) {
		int pass = 0;
		int points = 0;
		pass = val / 100;

		if (val > 49 && val < 101 && pass == 0) {
			points = val;
		}
		if (pass > 0) {
			val = val - 100;
			points = 50 + (val * 2);
		}

		return points;
	}

}
