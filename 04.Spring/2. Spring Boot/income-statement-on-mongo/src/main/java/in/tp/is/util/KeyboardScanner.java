package in.tp.is.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class KeyboardScanner {

	private static Scanner scan = new Scanner(System.in);
	
	public static int readInt() {
		while(!scan.hasNextInt())
			scan.next();
		return scan.nextInt();
	}
	
	public static double readDouble() {
		while(!scan.hasNextDouble())
			scan.next();
		return scan.nextDouble();
	}
	
	public static long readLong() {
		while(!scan.hasNextLong())
			scan.next();
		return scan.nextLong();
	}
	
	public static String readString() {
		return scan.next();
	}
	
	public static LocalDate readDate(DateTimeFormatter format) {
		String str = scan.next();
		return LocalDate.parse(str, format);
	}
}