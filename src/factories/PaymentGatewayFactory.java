package factories;

import java.util.List;
import java.util.Map;

import gateways.PaymentGateway;
import services.PaymentService;

public class PaymentGatewayFactory {

	public static PaymentGateway getPaymentGateway() {
		Map<String, PaymentGateway> payementGateways = PaymentService.getPaymentService().getPaymentGateways();
		int noOfGateways = payementGateways.size();
		PaymentGateway paymentGatewayWithMaxSuccessRate = null;
		PaymentGateway paymentGatewayWithMinTrafficServed = null;
		int totalTrafficServed = 0;
		double maxSuccessRate = -1;
		int leastTrafficServed = Integer.MAX_VALUE;
		
		for(String id : payementGateways.keySet()) {
			PaymentGateway paymentGateway = payementGateways.get(id);
			totalTrafficServed += paymentGateway.getTrafficServed();
			if(paymentGateway.getSuccessRate() > maxSuccessRate) {
				maxSuccessRate = paymentGateway.getSuccessRate();
				paymentGatewayWithMaxSuccessRate = paymentGateway;
			}
			
			if(paymentGateway.getTrafficServed() < leastTrafficServed) {
				leastTrafficServed = paymentGateway.getTrafficServed();
				paymentGatewayWithMinTrafficServed = paymentGateway;
			}
		}
		
		if(paymentGatewayWithMaxSuccessRate != null && paymentGatewayWithMinTrafficServed != null) {
			if(totalTrafficServed != 0 && leastTrafficServed/totalTrafficServed < noOfGateways) {
				return paymentGatewayWithMinTrafficServed;
			} 
			return paymentGatewayWithMaxSuccessRate;
		} else if(paymentGatewayWithMaxSuccessRate != null) {
			return paymentGatewayWithMaxSuccessRate;
		} else {
			return paymentGatewayWithMinTrafficServed;
		}
	}
	
}
