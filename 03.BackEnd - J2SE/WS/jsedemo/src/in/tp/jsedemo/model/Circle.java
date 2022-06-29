package in.tp.jsedemo.model;

public class Circle implements Shape {

	private static double PI = 3.14; 
	
	private int radius;
	
	public Circle() {
		this.radius=10;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return PI*radius*radius;
	}
	
	public double getPerimeter() {
		return 2 * PI * radius;
	}
}
