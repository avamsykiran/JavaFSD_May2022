package in.tp.jsedemo.model;

public class Rectangle {
	private int length;
	private int breadth;

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

	public int getArea() {
		return length * breadth;
	}

	public int getPerimeter() {
		return 2 * (length + breadth);
	}
}