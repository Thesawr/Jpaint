package view.gui;

import controller.Point;
import model.Config;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.interfaces.IShape;

public class Shape implements IShape{

	ApplicationState appState;
	Config shapeConfig;
		
	public Shape(Config shapeConfig)
	{
		this.shapeConfig = shapeConfig;
	}

	@Override
	public void makeShape()
	{
		IShape s = null;
		ShapeType shapeType = shapeConfig.shapeType;
		
		if (shapeType.equals(ShapeType.RECTANGLE))
			s = ShapeFactory.DrawRectangle(shapeConfig);
		else if (shapeType.equals(ShapeType.ELLIPSE))
			s = ShapeFactory.DrawEllipse(shapeConfig);
		else if (shapeType.equals(ShapeType.TRIANGLE))
			s = ShapeFactory.DrawTriangle(shapeConfig);
		
		s.makeShape();	
	}
	
	@Override
	public void makeSelect()
	{
		IShape s = null;
		ShapeType shapeType = shapeConfig.shapeType;
		
		if (shapeType.equals(ShapeType.RECTANGLE))
			s = ShapeFactory.DrawRectangle(shapeConfig);
		else if (shapeType.equals(ShapeType.ELLIPSE))
			s = ShapeFactory.DrawEllipse(shapeConfig);
		else if (shapeType.equals(ShapeType.TRIANGLE))
			s = ShapeFactory.DrawTriangle(shapeConfig);
		
		s.makeSelect();	
	}

	@Override
	public int getX() {
		return Math.min(shapeConfig.Start.getX(), shapeConfig.End.getX());
	}

	@Override
	public int getY() {
		return Math.min(shapeConfig.Start.getY(), shapeConfig.End.getY());
	}

	@Override
	public int getWidth()
	{
		return Math.abs(shapeConfig.Start.getX() - shapeConfig.End.getX());
	}

	@Override
	public int getHeight()
	{
		return Math.abs(shapeConfig.Start.getY() - shapeConfig.End.getY());
	}
	
	@Override
	public Point getStartPoint()
	{
		return shapeConfig.Start;
	}

	@Override
	public Point getEndPoint()
	{
		return shapeConfig.End;
	}
	
	@Override
	public void setStartPoint(int x, int y)
	{
		shapeConfig.Start = new Point(x, y);
	}

	@Override
	public void setEndPoint(int x, int y)
	{
		shapeConfig.End = new Point(x, y);	
	}

	@Override
	public Config getShapeConfig()
	{
		return shapeConfig;
	}

}
