package view.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

import controller.Point;
import model.Config;
import model.ShapeShadingType;
import view.interfaces.IShape;

public class Ellipse implements IShape{
	
	Config shapeConfig;
	int x,y,w,h;
	Point Start, End;
	
	public Ellipse(Config shapeConfig)
	{
		this.shapeConfig = shapeConfig;
		this.x = Math.min(shapeConfig.Start.getX(), shapeConfig.End.getX());
		this.y = Math.min(shapeConfig.Start.getY(), shapeConfig.End.getY()); 
		this.w = Math.abs(shapeConfig.End.getX() - shapeConfig.Start.getX());
		this.h = Math.abs(shapeConfig.End.getY() - shapeConfig.Start.getY());
	}

	@Override
	public void makeShape()
	{
		if (shapeConfig.shadingType.equals(ShapeShadingType.OUTLINE))
		{
			shapeConfig.g.setColor(shapeConfig.primaryColor.getColor());
			shapeConfig.g.setStroke(new BasicStroke(5));
			shapeConfig.g.drawOval(x, y, w, h);
        }
		else if (shapeConfig.shadingType.equals(ShapeShadingType.FILLED_IN))
		{
			shapeConfig.g.setColor(shapeConfig.primaryColor.getColor());
			shapeConfig.g.fillOval(x, y, w, h);
        }
		else if (shapeConfig.shadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN))
		{
			shapeConfig.g.setColor(shapeConfig.secondColor.getColor());
            shapeConfig.g.setStroke(new BasicStroke(5));
            shapeConfig.g.drawOval(x, y, w, h);
            shapeConfig.g.setColor(shapeConfig.primaryColor.getColor());
            shapeConfig.g.fillOval(x, y, w, h);
        }
		
		System.out.println("Draw Ellipse!");
	}
	
	@Override
	public void makeSelect()
	{
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
		shapeConfig.g.setStroke(stroke);
		shapeConfig.g.setColor(Color.BLACK);
		shapeConfig.g.drawOval(x-5, y-5, w+10, h+10);
	}

	@Override
	public int getX()
	{
		return this.x;
	}

	@Override
	public int getY()
	{
		return this.y;
	}
	
	@Override
	public int getWidth()
	{
		return this.w;
	}

	@Override
	public int getHeight()
	{
		return this.h;
	}

	@Override
	public Point getStartPoint()
	{
		return Start;
	}

	@Override
	public Point getEndPoint()
	{
		return End;
	}

	@Override
	public void setStartPoint(int x, int y)
	{
		Start = new Point(x, y);	
	}

	@Override
	public void setEndPoint(int x, int y)
	{
		End = new Point(x, y);
	}

	@Override
	public Config getShapeConfig()
	{
		return shapeConfig;
	}

}
