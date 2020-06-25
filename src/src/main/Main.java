package main;

import java.awt.Graphics2D;

import controller.IJPaintController;
import controller.JPaintController;
import model.ShapeList;
import model.persistence.ApplicationState;
import view.gui.Gui;
import view.gui.GuiWindow;
import view.gui.Mouse;
import view.gui.PaintCanvas;
import view.interfaces.IGuiWindow;
import view.interfaces.PaintCanvasBase;
import view.interfaces.IUiModule;

public class Main {
    public static void main(String[] args){
    	
    	ShapeList shapeList = new ShapeList();
    	PaintCanvasBase paintCanvas = new PaintCanvas();
        IGuiWindow guiWindow = new GuiWindow(paintCanvas);
        IUiModule uiModule = new Gui(guiWindow);
        ApplicationState appState = new ApplicationState(uiModule);
        
        Graphics2D g = paintCanvas.getGraphics2D();
        
        IJPaintController controller = new JPaintController(uiModule, appState, shapeList);
        
        Mouse mouse = new Mouse(appState, paintCanvas, shapeList);
    	paintCanvas.addMouseListener(mouse);
        controller.setup();
        
        // Clears the Canvas
        //paintCanvas.repaint();
    }
}