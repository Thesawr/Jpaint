package model.interfaces;

import java.util.ArrayList;

import view.interfaces.IShape;

public interface IShapeList {
	void addShape(IShape s);
	public void removeShape(IShape s);
	public ArrayList<IShape> getShapeList();
	public int getSize();
	
	public void addSelected(IShape s);
	public void removeSelected(IShape s);
	public ArrayList<IShape> getSelectedList();
	public int getSelectedSize();
	public void clearSelected();
	
	public void addClipBoard(IShape s);
	public void removeClipBoard();
	public void clearClipBoard();
	public ArrayList<IShape> getClipBoard();

	public void update();
}
