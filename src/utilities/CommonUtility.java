package utilities;

import java.util.Deque;
import java.util.Queue;

import models.Payment;
import models.PaymentPair;

public class CommonUtility {

	public static void updateQueue(Deque<PaymentPair> queue, Payment payment) {
		long currentTimeStamp = System.currentTimeMillis();
		while(!queue.isEmpty()) {
			long timeStamp = queue.getLast().getTimeStamp();
			if(currentTimeStamp - timeStamp >= 30*60*1000) {
				queue.removeLast();
			} else {
				break;
			}
		}
		queue.addFirst(new PaymentPair(currentTimeStamp, getRandomBoolean()));
	}
	
	public static boolean getRandomBoolean() {
		int x = 1 + (int)Math.random()*100;
		return x % 2 == 0;
	}
	
}
