package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import factories.PaymentGatewayFactory;
import gateways.PayTM;
import gateways.PayU;
import gateways.PaymentGateway;
import gateways.RazorPay;
import models.Payment;

public class PaymentService {

	private static PaymentService instance;
	Map<String, PaymentGateway> paymentGatewaysMap;

	private PaymentService() {
		this.paymentGatewaysMap = new HashMap<String, PaymentGateway>();
		addPaymentGateway(new PayTM());
		addPaymentGateway(new PayU());
		addPaymentGateway(new RazorPay());
	}

	public static PaymentService getPaymentService() {
		if(instance == null) {
			instance = new PaymentService();
		}
		return instance;
	}

	public void addPaymentGateway(PaymentGateway paymentGateway) {
		this.paymentGatewaysMap.put(paymentGateway.getId(), paymentGateway);
	}
	
	public Map<String, PaymentGateway> getPaymentGateways() {
		return paymentGatewaysMap;
	}
	
	public void processPayment(Payment payment) {
		PaymentGatewayFactory.getPaymentGateway().processPayment(payment);
	}
}
