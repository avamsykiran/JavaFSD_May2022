package in.tp.jsedemo.ui;

import in.tp.jsedemo.model.Rectangle;

public class ClassObjectDemoApp {

	public static void main(String[] args) {
		Rectangle r1= new Rectangle(); 
        Rectangle r2= new Rectangle(); 

        r1.setLength(6);
        r1.setBreadth(8);
        System.out.println(r1.getArea());

        r2.setLength(156);
        r2.setBreadth(288);
        System.out.println(r2.getArea());
	}

}
