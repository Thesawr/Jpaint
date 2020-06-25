package view.gui;

import model.Config;
import view.interfaces.IShape;

public class ShapeFactory {

	public static IShape DrawEllipse(Config shapeConfig) {
		return new Ellipse(shapeConfig);
	}
	
	public static IShape DrawRectangle(Config shapeConfig) {
		return new Rectangle(shapeConfig);
	}
	
	public static IShape DrawTriangle(Config shapeConfig) {
		return new Triangle(shapeConfig);
	}
}
