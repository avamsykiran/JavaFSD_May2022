package in.tp.jd.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GreetServiceTest {

	GreetService gs;
	
	@BeforeEach
	public void setUp() {
		gs= new GreetService();
	}
	
	@AfterEach
	public void clean() {
		gs= null;
	}
	
	@Test
	void testGreet() {
		String input = "Vamsy";
		String actual = gs.greet(input);
		String expected = "Hello Vamsy";
		assertEquals(expected, actual);
	}

	@Test
	void testGreetIn() {
		assertAll(() -> {
			assertEquals("Hello Vamsy", gs.greetIn("Vamsy", "en"));
		}, () -> {
			assertEquals("Namaskar Vamsy", gs.greetIn("Vamsy", "hi"));
		}, () -> {
			assertEquals("Namaskaram Vamsy", gs.greetIn("Vamsy", "te"));
		}, () -> {
			assertEquals("Vanakkam Vamsy", gs.greetIn("Vamsy", "tm"));
		}, () -> {
			assertNull(gs.greetIn("Vamsy", "xyz"));
		});

	}
}
