package model.interfaces;

import java.awt.Graphics2D;

import controller.Point;
import model.ShapeColor;
import model.ShapeList;
import model.ShapeShadingType;
import model.ShapeType;
import model.persistence.ApplicationState;

public interface IConfig {
	Graphics2D getGraphics2D();
	Point getStart();
	Point getEnd();
	ShapeType getShapeType();
	ShapeShadingType getShadingType();
	ShapeColor getPrimaryColor();
	ShapeColor getSecondColor();
	ApplicationState getAppState();
	ShapeList getShapeList();
}
