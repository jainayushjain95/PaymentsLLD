package gateways;
import models.Payment;
import utilities.CommonUtility;

public class RazorPay extends PaymentGateway {
	
	@Override
	public void submitResult(Payment payment) {
		CommonUtility.updateQueue(this.queue, payment);
	}

	@Override
	public void processPayment(Payment payment) {
		System.out.println("Payment is being processed...");
		System.out.println("Payment processed");
	}
}
