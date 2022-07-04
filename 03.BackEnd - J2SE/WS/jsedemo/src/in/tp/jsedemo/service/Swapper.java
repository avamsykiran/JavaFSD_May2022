package in.tp.jsedemo.service;

public class Swapper<T> {
	public void swap(T a, T b) {
		System.out.println("Before Swapping \t" + a + "\t" + b);
		T t = a;
		a = b;
		b = t;
		System.out.println("After Swapping \t" + a + "\t" + b);
	}
}