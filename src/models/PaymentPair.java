package models;

public class PaymentPair {
	
	long timeStamp;
	boolean isSuccess;
	
	public PaymentPair(long timeStamp, boolean isSuccess) {
		super();
		this.timeStamp = timeStamp;
		this.isSuccess = isSuccess;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	
	
	
}
