package view.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Stroke;

import controller.Point;
import model.Config;
import model.ShapeShadingType;
import view.interfaces.IShape;

public class Triangle implements IShape {
	
	Config shapeConfig;
	int x,y,w,h;
	int[] SetOfX = new int[3];
    int[] SetOfY = new int[3];
    //int[] SelectOfX = new int[3];
    //int[] SelectOfY = new int[3];
	Point Start, End;
	
	public Triangle(Config shapeConfig)
	{		
		this.shapeConfig = shapeConfig;
		
		this.x = Math.min(shapeConfig.Start.getX(), shapeConfig.End.getX());
		this.y = Math.min(shapeConfig.Start.getY(), shapeConfig.End.getY()); 
		this.w = Math.abs(shapeConfig.End.getX() - shapeConfig.Start.getX());
		this.h = Math.abs(shapeConfig.End.getY() - shapeConfig.Start.getY());
		
		this.SetOfX[0] = shapeConfig.Start.getX();
        this.SetOfX[1] = shapeConfig.End.getX();
        this.SetOfX[2] = shapeConfig.Start.getX();

        this.SetOfY[0] = shapeConfig.Start.getY();
        this.SetOfY[1] = shapeConfig.End.getY();
        this.SetOfY[2] = shapeConfig.End.getY();
	}

	@Override
	public void makeShape()
	{		
		if (shapeConfig.shadingType.equals(ShapeShadingType.OUTLINE))
		{
			shapeConfig.g.setColor(shapeConfig.primaryColor.getColor());
			shapeConfig.g.setStroke(new BasicStroke(5));
			shapeConfig.g.drawPolygon(SetOfX, SetOfY, 3);

        }
		else if (shapeConfig.shadingType.equals(ShapeShadingType.FILLED_IN))
		{
			shapeConfig.g.setColor(shapeConfig.primaryColor.getColor());
			shapeConfig.g.fillPolygon(SetOfX, SetOfY, 3);

        }
		else if (shapeConfig.shadingType.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN))
		{
			shapeConfig.g.setColor(shapeConfig.secondColor.getColor());
            shapeConfig.g.setStroke(new BasicStroke(5));
            shapeConfig.g.drawPolygon(SetOfX, SetOfY, 3);
            shapeConfig.g.setColor(shapeConfig.primaryColor.getColor());
            shapeConfig.g.fillPolygon(SetOfX, SetOfY, 3);
        }
		
		System.out.println("Draw Triangle!");
		
	}
	
	@Override
	public void makeSelect()
	{
		Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
		shapeConfig.g.setStroke(stroke);
		shapeConfig.g.setColor(Color.BLACK);
		shapeConfig.g.drawPolygon(SetOfX, SetOfY, 3);
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
