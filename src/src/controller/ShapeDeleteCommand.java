package controller;

import java.util.ArrayList;

import model.ShapeList;
import model.interfaces.IUndoable;
import view.interfaces.IShape;

public class ShapeDeleteCommand implements ShapeCommand, IUndoable{
	
	private ShapeList shapeList;
    ArrayList<IShape> selectedShapes;
    ArrayList<IShape> temp = new ArrayList<IShape>();
    
    public ShapeDeleteCommand(ShapeList shapeList)
	{
        this.shapeList = shapeList;
    }
    
	@Override
	public void run()
	{
		selectedShapes = shapeList.getSelectedList();
        
        for (IShape shape : selectedShapes)
        {
        	shapeList.removeShape(shape);
        	temp.add(shape);
        	shapeList.update();
        }
        
        shapeList.clearSelected();
        shapeList.update();
     
        System.out.println("Delete");
        CommandHistory.add(this);
	}

	@Override
	public void undo() {       
        for (IShape shape : temp)
        {
        	shapeList.addShape(shape);
        	shapeList.addSelected(shape);
        	shapeList.update();
        } 		
	}

	@Override
	public void redo() {		
		for (IShape shape : temp)
        {
			shapeList.removeShape(shape);
        	shapeList.removeSelected(shape);
        	shapeList.update();
        } 		
	}

}
