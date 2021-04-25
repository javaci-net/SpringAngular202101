import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MyUnitTest {

	private MyUnit u;
	
	@BeforeEach
	public void hazirlik() {
		u = new MyUnit();
	}
	
	@Test
	@DisplayName("Guzel guzel isimler")
	public void concatTest1() {
		String r = u.contatenate("a", "b");
		assertEquals("ab", r);
	}
	
	@Test
	public void concatTest2() {
		String r = u.contatenate("a", null);
		assertEquals("a", r);
		
	}
	
	@Test
	public void concatTest3() {
		String r = u.contatenate(null, "a");
		assertEquals("a", r);
	}
}
