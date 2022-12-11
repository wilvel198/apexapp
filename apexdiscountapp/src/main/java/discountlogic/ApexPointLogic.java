package discountlogic;

import org.springframework.stereotype.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.apex.constants.Constants;
import com.apex.models.ResponseValue;

@Component
public class ApexPointLogic {

	private static final Logger LOGGER = LogManager.getLogger(ApexPointLogic.class);

	public ResponseValue getServiceStatus() {
		LOGGER.debug("Debug place holder - get service status");
		
		ResponseValue response2Call = new ResponseValue();
		response2Call.setResponseInformation(Constants.statusMsg);
		
		return response2Call;
	}

	public ResponseValue calculateDiscount(int spentVal) {
		LOGGER.debug("Debug place holder - calculate discount");
		ResponseValue response2Call = new ResponseValue();
		int pointCount = 0;

		pointCount = calculatePoints(spentVal);
		response2Call.setResponseInformation("Calculated Points :" + pointCount);

		return response2Call;

	}

	// logic to calculate points
	private static int calculatePoints(int val) {
		LOGGER.debug("Debug place holder - calculate discount subroutine");
		
		int pass = 0;
		int points = 0;
		pass = val / 100;

		if (val > 49 && val < 101 && pass == 0) {
			points = val - 50;
		}
		if (pass > 0) {
			val = val - 100;
			points = 50 + (val * 2);
		}

		return points;
	}

}
