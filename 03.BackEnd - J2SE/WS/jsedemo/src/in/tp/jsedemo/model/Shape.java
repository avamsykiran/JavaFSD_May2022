package in.tp.jsedemo.model;

public interface Shape {
	double getArea();
	double getPerimeter();
	
	default double estimatePaintingCost(double paintingRate) {
		return getArea()*paintingRate;
	}
}
