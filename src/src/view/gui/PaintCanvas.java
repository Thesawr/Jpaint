package view.gui;

import view.interfaces.PaintCanvasBase;
import java.awt.*;

import model.interfaces.IApplicationState;

@SuppressWarnings("serial")
public class PaintCanvas extends PaintCanvasBase {
	
	private IApplicationState applicationState;

    public Graphics2D getGraphics2D() {
        return (Graphics2D)getGraphics();
    }
}
