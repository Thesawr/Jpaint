package view.interfaces;

import controller.Point;
import model.Config;

public interface IShape {
	
	void makeShape();
	int getX();
	int getY();
	int getWidth();
	int getHeight();
	Point getStartPoint();
	Point getEndPoint();
	void setStartPoint(int x, int y);
	void setEndPoint(int x, int y);
	Config getShapeConfig();
	void makeSelect();
	
}
