package controller;

import model.interfaces.IUndoable;
import model.Config;
import view.interfaces.IShape;

public class ShapeMoveCommand implements ShapeCommand, IUndoable{
	IShape NewShape, OldShape;
	Point Start, End;
	Config shapeConfig;
	
	public ShapeMoveCommand(Config shapeConfig)
	{
		this.shapeConfig = shapeConfig;
		this.Start = shapeConfig.Start;
		this.End = shapeConfig.End;
	}

	@Override
	public void run()
	{
		System.out.println("MOVE");
		
		int DiffX = End.getX() - Start.getX();
		int DiffY = End.getY() - Start.getY();
		
		for (IShape s: shapeConfig.shapeList.getSelectedList())
		{
			shapeConfig.shapeList.removeShape(s);
			OldShape = s;
			IShape SelectShape = s;
			
			SelectShape.setStartPoint(SelectShape.getStartPoint().getX() + DiffX, SelectShape.getStartPoint().getY() + DiffY);
			SelectShape.setEndPoint(SelectShape.getEndPoint().getX() + DiffX, SelectShape.getEndPoint().getY() + DiffY);
			shapeConfig.shapeList.addShape(SelectShape);
			shapeConfig.shapeList.update();	
			NewShape = SelectShape;
		}
		System.out.println("Moved");		
		CommandHistory.add(this);	
	}

	@Override
	public void undo() {		
		int DiffX = End.getX() - Start.getX();
		int DiffY = End.getY() - Start.getY();
		
		for (IShape s: shapeConfig.shapeList.getSelectedList())
		{
			shapeConfig.shapeList.removeShape(s);
			OldShape = s;
			IShape SelectShape = s;
			
			SelectShape.setStartPoint(SelectShape.getStartPoint().getX() - DiffX, SelectShape.getStartPoint().getY() - DiffY);
			SelectShape.setEndPoint(SelectShape.getEndPoint().getX() - DiffX, SelectShape.getEndPoint().getY() - DiffY);
			shapeConfig.shapeList.addShape(SelectShape);
			shapeConfig.shapeList.update();	
			NewShape = SelectShape;
		}	
	}

	@Override
	public void redo() {
		int DiffX = End.getX() - Start.getX();
		int DiffY = End.getY() - Start.getY();
		
		for (IShape s: shapeConfig.shapeList.getSelectedList())
		{
			shapeConfig.shapeList.removeShape(s);
			OldShape = s;
			IShape SelectShape = s;
			
			SelectShape.setStartPoint(SelectShape.getStartPoint().getX() + DiffX, SelectShape.getStartPoint().getY() + DiffY);
			SelectShape.setEndPoint(SelectShape.getEndPoint().getX() + DiffX, SelectShape.getEndPoint().getY() + DiffY);
			shapeConfig.shapeList.addShape(SelectShape);
			shapeConfig.shapeList.update();	
			NewShape = SelectShape;
		}	
	}
	
}
