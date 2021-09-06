package models;
import java.util.UUID;

public class Payment {

	String id;
	double amount;
	String userId;
	
	public Payment(double amount, String userId) {
		super();
		this.amount = amount;
		this.userId = userId;
		this.id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
