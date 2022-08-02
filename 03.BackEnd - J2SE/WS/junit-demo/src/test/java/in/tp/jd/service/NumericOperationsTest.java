package in.tp.jd.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumericOperationsTest {

	NumericalOperations numOp;
	
	@BeforeEach
	void start() {
		numOp=new NumericalOperations();
	}
	
	@AfterEach
	void clean() {
		numOp=null;
	}
	
	@ParameterizedTest
	@ValueSource(ints = {-2,0,2})
	@Tag("ptest")
	@DisplayName("isEven should return true for given even numbers")
	void testIsEven1(int x) {
		assertTrue(numOp.isEven(x));
	}

	@ParameterizedTest
	@Tag("ptest")
	@ValueSource(ints = {-1,1})
	@DisplayName("isEven should return false for given odd numbers")
	void testIsEven2(int x) {
		assertFalse(numOp.isEven(x));
	}
	
	@ParameterizedTest
	@Tag("ptest")
	@CsvSource(value = {"-2;-2;-4","-2;2;0","0;0;0","2;-2;0","2;2;4","2;0;2","0;2;2"},delimiter = ';')
	@DisplayName("sum should return additive result for given numbers")
	void testSum(int x,int y,int expected) {
		assertEquals(expected, numOp.sum(x, y));
	}
}
