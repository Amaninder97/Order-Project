package demo;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderServiceApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("MainFile");
		int a = 1, b = 1;
		assertEquals(2, a + b);
	}

}
