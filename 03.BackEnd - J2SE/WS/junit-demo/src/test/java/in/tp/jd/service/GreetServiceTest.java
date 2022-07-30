package in.tp.jd.service;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import in.tp.jd.exception.InvalidUserException;
import in.tp.jd.model.Gender;
import in.tp.jd.model.User;

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
	
	public static Stream<Arguments> provideTestDataForTestGreetUser(){
		return Stream.of(
				Arguments.of(new User("Srinu", LocalDate.now().minusYears(40), Gender.GENT),"Hello Mr. Srinu"),
				Arguments.of(new User("Srinu", LocalDate.now().minusYears(5), Gender.GENT),"Hello Master. Srinu"),
				Arguments.of(new User("Deepa", LocalDate.now().minusYears(40), Gender.LADY),"Hello Ms. Deepa"),
				Arguments.of(new User("Deepa", LocalDate.now().minusYears(5), Gender.LADY),"Hello Baby. Deepa")
				);
	}
	
	@ParameterizedTest
	@MethodSource("provideTestDataForTestGreetUser")
	@DisplayName("greetUSer shall return greeting for the given user")
	void testGreetUser(User user,String expected) throws InvalidUserException {
		assertEquals(expected, gs.greetUser(user));
	}
	
	@Test
	@DisplayName("greetUSer shall throw invalid user exception given null")
	void testGreetUser2(){
		assertThrows(InvalidUserException.class, () -> {gs.greetUser(null);});
	}
}
