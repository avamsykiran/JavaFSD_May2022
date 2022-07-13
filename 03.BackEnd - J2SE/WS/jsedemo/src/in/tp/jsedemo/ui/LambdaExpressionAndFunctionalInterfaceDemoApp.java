package in.tp.jsedemo.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.IntBinaryOperator;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class LambdaExpressionAndFunctionalInterfaceDemoApp {

	public static void main(String[] args) {

		IntPredicate isEven = n -> n%2==0;
		System.out.println("123 is even: " +isEven.test(123));
		System.out.println("124 is even: " +isEven.test(124));
		
		IntBinaryOperator sum = (a,b) -> a+b;
		System.out.println(sum.applyAsInt(45, 66));
		
		Supplier<LocalDate> today = () -> LocalDate.now();
		System.out.println(today.get());
		
		UnaryOperator<String> greet = userName -> {
			String greeting="";
			
			int h = LocalDateTime.now().getHour();
			
			if(h>=3 && h<=11) greeting="Good Morning";
			else if(h>=12 && h<=17) greeting="Good Noon";
			else greeting="Good Evening";
			
			return greeting + " "+userName;
		};
		System.out.println(greet.apply("Vamsy Kiran"));
	}

}
