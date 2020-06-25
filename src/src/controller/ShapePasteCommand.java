package controller;

import java.util.ArrayList;

import model.ShapeList;
import view.interfaces.IShape;

public class ShapePasteCommand implements ShapeCommand{
	
	private ShapeList shapeList;
    ShapeCommand shapeCommand;
    private final ArrayList<IShape> temp = new ArrayList<IShape>();

	public ShapePasteCommand(ShapeList shapeList)
	{
        this.shapeList = shapeList;
    }
	
	@Override
	public void run()
	{
		for (IShape selectedShape : shapeList.getSelectedList())
		{
            selectedShape.setStartPoint(selectedShape.getStartPoint().getX()+20, selectedShape.getStartPoint().getY()+20);
            selectedShape.setEndPoint(selectedShape.getEndPoint().getX()+20, selectedShape.getEndPoint().getY()+20);
            temp.add(selectedShape);
        }

        for (IShape selectedShape : temp)
        {
        	shapeCommand = new ShapeCreateCommand(selectedShape.getShapeConfig());
        	shapeCommand.run();
        	shapeList.addShape(selectedShape);
            System.out.println("Paste");
            
        }	
	}

}
