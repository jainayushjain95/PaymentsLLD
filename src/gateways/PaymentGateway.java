package gateways;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

import models.Payment;
import models.PaymentPair;

public abstract class PaymentGateway {

	private String id;
	Deque<PaymentPair> queue;
	double successRate;

	public abstract void submitResult(Payment payment);
	public abstract void processPayment(Payment payment);
	
	public PaymentGateway() {
		super();
		this.queue = new LinkedList<>();
		this.successRate = 0.0;
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public double getSuccessRate() {
		return successRate;
	}

	public void setSuccessRate(double successRate) {
		this.successRate = successRate;
	}
	
	public int getTrafficServed() {
		return queue.size();
	}
}
