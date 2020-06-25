package model;

import java.awt.Graphics2D;

import controller.Point;
import model.interfaces.IConfig;
import model.persistence.ApplicationState;

public class Config implements IConfig{
	public Graphics2D g;
	public Point Start, End;
	public ShapeType shapeType;
	public ShapeShadingType shadingType;
	public ShapeColor primaryColor;
	public ShapeColor secondColor;
	public ApplicationState appState;
	public ShapeList shapeList;
	public NullObject IfNull;
	
	
	public Config(Graphics2D g, ApplicationState appState, ShapeList shapeList, Point Start, Point End)
	{
		if(g == null || appState == null || shapeList == null || Start == null || End == null) {
			IfNull = new NullObject();
			
			g = IfNull.getGraphics2D();
			appState = IfNull.getAppState();
			shapeList = IfNull.getShapeList();
			Start = IfNull.getStart();
			End = IfNull.getEnd();
		}
		
		this.g = g;
		this.appState = appState;
		this.shapeList = shapeList;
		this.shapeType = appState.getActiveShapeType();
		this.shadingType = appState.getActiveShapeShadingType();
		this.primaryColor = appState.getActivePrimaryColor();
		this.secondColor = appState.getActiveSecondaryColor();
		this.Start = Start;
		this.End = End;
	}


	@Override
	public Graphics2D getGraphics2D() {
		return this.g;
	}


	@Override
	public Point getStart() {
		return this.Start;
	}


	@Override
	public Point getEnd() {
		return this.End;
	}

	@Override
	public ShapeType getShapeType() {
		return this.shapeType;
	}


	@Override
	public ShapeShadingType getShadingType() {
		return this.shadingType;
	}


	@Override
	public ShapeColor getPrimaryColor() {
		return this.primaryColor;
	}


	@Override
	public ShapeColor getSecondColor() {
		return this.secondColor;
	}


	@Override
	public ApplicationState getAppState() {
		return this.appState;
	}


	@Override
	public ShapeList getShapeList() {
		return this.shapeList;
	}

}
