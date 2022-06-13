package in.tp.jsedemo.ui;

import java.util.Scanner;

public class HelloWorldApp {

	public static void main(String[] args) {
		System.out.println("Hello World! Welcome To Java 11");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("What`s your name? ");
		String name = scanner.next();
		
		System.out.println("How old are you? ");
		int age = scanner.nextInt();
		
		System.out.println(String.format("Hello! %s! So you are just %d years old", name,age));
	}

}
