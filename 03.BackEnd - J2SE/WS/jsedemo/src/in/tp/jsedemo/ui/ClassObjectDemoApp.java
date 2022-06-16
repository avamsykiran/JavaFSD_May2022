package in.tp.jsedemo.ui;

import in.tp.jsedemo.model.Circle;
import in.tp.jsedemo.model.Rectangle;

public class ClassObjectDemoApp {

	public static void main(String[] args) {
		Rectangle r1= new Rectangle(); 
        System.out.println(r1.getArea());

        Rectangle r2= new Rectangle();         
        r2.setLength(2);
        r2.setBreadth(4);
        System.out.println(r2.getArea());
        
        Rectangle r3 = Rectangle.add(r1, r2);
        System.out.println(r3.getArea());
        
        Circle c = new Circle();
        System.out.println(c.getArea());
	}

}
