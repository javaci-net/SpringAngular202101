
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class MyQueueTest {

	private MyQueue<String> qStr;
	private MyQueue<Integer> qInt;
	
	@BeforeEach
	public void setupQueue() {
		qStr = new MyQueue<String>();
		qInt = new MyQueue<Integer>();
	}
	
	@Test
	public void testPush() {
		qStr.push("bir");
		qStr.push("iki");
		assertEquals(2, qStr.size());
		
	}
	

	@Test
	public void testPushInteger() {
		qInt.push(1);
		qInt.push(2);
		assertEquals(2, qInt.size());
		
	}
	

	@Test
	public void testPushPop() {
		qStr.push("bir");
		qStr.push("iki");
		assertEquals("iki", qStr.pop());
		assertEquals("bir", qStr.pop());
		
		assertEquals(0, qStr.size());
		assertThrows(IllegalStateException.class, ()-> {
			qStr.pop();
		});
	}
	
	@Test
	public void testPeek() {
		
		qStr.push("bir");
		qStr.push("iki");
		assertEquals("iki", qStr.peek());
		assertEquals("iki", qStr.peek());

		assertEquals(2, qStr.size());
		
	}
	
}
 