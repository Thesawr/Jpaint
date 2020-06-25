package view.gui;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controller.Point;
import controller.ShapeCommand;
import controller.ShapeCreateCommand;
import controller.ShapeMoveCommand;
import controller.ShapeSelectCommand;
import model.ShapeList;
import model.StartAndEndPointMode;
import model.Config;
import model.ShapeType;
import model.persistence.ApplicationState;
import view.interfaces.PaintCanvasBase;

public class Mouse extends MouseAdapter{
	ApplicationState appState;
    PaintCanvasBase paintCanvas;
    Config shapeConfig;
    ShapeList shapeList;
	ShapeType shapeType;
    Point Start, End; 
    Graphics2D g;
    ShapeCommand shapeCommand;
    
    

    public Mouse(ApplicationState applicationState, PaintCanvasBase paintCanvas, ShapeList shapeList)
    {
        this.appState = applicationState;
        this.paintCanvas = paintCanvas;
        this.shapeList = shapeList; 
    }
    
    @Override
    public void mousePressed(MouseEvent e)
    {
    	Start = new Point(e.getX(), e.getY());
    	System.out.println("Mouse Pressed!");
    }
    
    @Override
    public void mouseReleased(MouseEvent e)
    {
    	End = new Point(e.getX(), e.getY());
    	
    	System.out.println("Mouse Released!");
        
    	Graphics2D g = paintCanvas.getGraphics2D();
    	shapeConfig = new Config(g, appState, shapeList, Start, End);
    	StartAndEndPointMode startAndEndPointMode = appState.getActiveStartAndEndPointMode();
    	
    	if (startAndEndPointMode.equals(StartAndEndPointMode.DRAW))
    	{
			shapeCommand = new ShapeCreateCommand(shapeConfig);
    	}
    	else if (startAndEndPointMode.equals(StartAndEndPointMode.SELECT))
    	{
    		shapeCommand = new ShapeSelectCommand(shapeConfig);
    	}
    	else if (startAndEndPointMode.equals(StartAndEndPointMode.MOVE))
    	{
    		shapeCommand = new ShapeMoveCommand(shapeConfig);
    	}
    	
    	shapeCommand.run();
    }
}