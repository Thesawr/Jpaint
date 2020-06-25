package controller;

import model.ShapeList;
import view.interfaces.IShape;

public class ShapeCopyCommand implements ShapeCommand{
	
	ShapeList shapeList;
	
	public ShapeCopyCommand(ShapeList shapeList)
	{
        this.shapeList = shapeList;
    }

	@Override
	public void run()
	{
		for (IShape s : shapeList.getSelectedList())
		{
			shapeList.addClipBoard(s);
        }
		System.out.println("Copy " + shapeList.getClipBoard().size() + " Shapes");
	}

}
