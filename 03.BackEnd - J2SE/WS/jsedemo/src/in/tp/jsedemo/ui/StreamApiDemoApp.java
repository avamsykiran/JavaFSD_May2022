package in.tp.jsedemo.ui;

import java.util.Arrays;
import java.util.Random;

public class StreamApiDemoApp {

	public static void main(String[] args) {
		Random random = new Random();
		
		int nums[] = new int[5];
		
		for(int i=0;i<5;i++)
			nums[i] = random.nextInt(100);
		
		Arrays.stream(nums).forEach( x -> {System.out.println(x); });
		System.out.println("---------------------------------------------------");
		Arrays.stream(nums).map(x -> x*x).forEach( x -> {System.out.println(x); });
		System.out.println("---------------------------------------------------");
		Arrays.stream(nums).filter(x -> x%2==0).forEach( x -> {System.out.println(x); });
		System.out.println("---------------------------------------------------");
		System.out.println(Arrays.stream(nums).reduce(0, (a,b) -> a+b));
		System.out.println("---------------------------------------------------");
		System.out.println(Arrays.stream(nums).reduce(nums[0], (a,b) -> a>b?a:b));
	}

}
