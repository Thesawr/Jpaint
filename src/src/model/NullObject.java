package model;

import java.awt.Graphics2D;

import controller.Point;
import model.interfaces.IConfig;
import model.persistence.ApplicationState;

public class NullObject implements IConfig {

	private IConfig paintCanvas;
	private ApplicationState appState;
	private ShapeList shapeList = new ShapeList();

	@Override
	public Graphics2D getGraphics2D() {
		return paintCanvas.getGraphics2D();
	}

	@Override
	public Point getStart() {
		return new Point(0,0);
	}

	@Override
	public Point getEnd() {
		return new Point(0,0);
	}

	@Override
	public ShapeType getShapeType() {
		return appState.getActiveShapeType();
	}

	@Override
	public ShapeShadingType getShadingType() {
		return appState.getActiveShapeShadingType();
	}

	@Override
	public ShapeColor getPrimaryColor() {
		return appState.getActivePrimaryColor();
	}

	@Override
	public ShapeColor getSecondColor() {
		return appState.getActiveSecondaryColor();
	}

	@Override
	public ApplicationState getAppState() {
		return appState;
	}

	@Override
	public ShapeList getShapeList() {
		return shapeList ;
	}

}
