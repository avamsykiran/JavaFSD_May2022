package in.tp.jsedemo.model;

public class Rectangle implements Shape {
	
	private int length;
	private int breadth;
	
	public Rectangle() {
		this.length=5;
		this.breadth=5;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}

	public int getBreadth() {
		return breadth;
	}

	public double getArea() {
		return length * breadth;
	}

	public double getPerimeter() {
		return 2 * (length + breadth);
	}
	
	public static Rectangle add(Rectangle a,Rectangle b) {
		Rectangle r = new Rectangle();
		r.length=a.length+b.length;
		r.breadth=a.breadth+b.breadth;
		return r;
	}
}