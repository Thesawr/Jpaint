package controller;

import java.util.ArrayList;

import model.Config;
import model.interfaces.IUndoable;
import view.interfaces.IShape;

public class ShapeSelectCommand implements ShapeCommand, IUndoable{
	Point Start, End;
	Config shapeConfig;
	ArrayList<IShape> temp = new ArrayList<IShape>();
	int x, y, w, h;
	
	public ShapeSelectCommand(Config shapeConfig)
	{
		this.shapeConfig = shapeConfig;
		this.Start = shapeConfig.Start;
		this.End = shapeConfig.End;
	}
	
	@Override
	public void run()
	{
		System.out.println("SELECT");
		
		shapeConfig.shapeList.getSelectedList().clear();

		 x = Math.min(Start.getX(), End.getX());
		 y = Math.min(Start.getY(), End.getY()); 
		 w = Math.abs(End.getX() - Start.getX());
		 h = Math.abs(End.getY() - Start.getY());

		for (IShape s: shapeConfig.shapeList.getShapeList())
		{ 	
			if (x < s.getX() + s.getWidth() && x + w > s.getX() && y < s.getY() + s.getHeight() && y + h > s.getY())
			{
				shapeConfig.shapeList.addSelected(s);
				temp.add(s);
			}
		}
		
		shapeConfig.shapeList.update();
		System.out.println("Select " + shapeConfig.shapeList.getSelectedSize() + "\n");
		
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		
		for (IShape s : temp)
        {
			shapeConfig.shapeList.removeSelected(s);
			shapeConfig.shapeList.update();
        } 		
	}

	@Override
	public void redo() {
		for (IShape s : temp)
        {
			shapeConfig.shapeList.addSelected(s);
			shapeConfig.shapeList.update();
        } 
	}
}
