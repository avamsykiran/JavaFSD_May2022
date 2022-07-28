package in.tp.jd.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GreetServiceTest {

	@Test
	void testGreet() {
		GreetService gs = new GreetService();
		String input = "Vamsy";
		String actual = gs.greet(input);
		String expected = "Hello Vamsy";
		assertEquals(expected, actual);
	}

	@Test
	void testGreetIn() {
		GreetService gs = new GreetService();
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
