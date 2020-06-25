package controller;

import model.interfaces.IUndoable;
import model.Config;
import view.gui.Shape;
import view.interfaces.IShape;

public class ShapeCreateCommand implements ShapeCommand, IUndoable{
	IShape shape;
	Config shapeConfig;
	
	public ShapeCreateCommand(Config shapeConfig)
	{
		this.shapeConfig = shapeConfig;
	}
	
	@Override
	public void run()
	{
		System.out.println("DRAW");
		
		shape = new Shape(shapeConfig);
		shape.makeShape();
		shapeConfig.shapeList.addShape(shape);
		
		CommandHistory.add(this);
	}

	@Override
	public void undo() {
		shapeConfig.shapeList.removeShape(shape);	
		shapeConfig.shapeList.update();
	}

	@Override
	public void redo() {
		shapeConfig.shapeList.addShape(shape);	
		shapeConfig.shapeList.update();
	}
}
