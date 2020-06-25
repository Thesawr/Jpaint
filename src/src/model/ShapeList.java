package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import model.interfaces.IShapeList;
import view.interfaces.IShape;

public class ShapeList implements IShapeList{
	Graphics2D g;
	ArrayList<IShape> shapeList;
	ArrayList<IShape> selectedList;
	ArrayList<IShape> clipBoard;
	
	public ShapeList() {
		shapeList = new ArrayList<IShape>();
		selectedList = new ArrayList<IShape>();
		clipBoard = new ArrayList<IShape>();
	}
	
	// Shape list 
	public void addShape(IShape s) {
		this.shapeList.add(s);
		this.g = s.getShapeConfig().g;
	}
	
	public void removeShape(IShape s) {
		this.shapeList.remove(s);
	}
	
	public ArrayList<IShape> getShapeList() {
		return shapeList;
	}

	public int getSize() {
		return shapeList.size();
	}
	
	
	// Select list 
	public void addSelected(IShape s) {
		this.selectedList.add(s);
		s.makeSelect();
	}
	
	public void removeSelected(IShape s) {
		this.selectedList.remove(s);
	}
	
	public ArrayList<IShape> getSelectedList() {
		return selectedList;
	}
	
	public int getSelectedSize() {
		return selectedList.size();
	}
	
	public void clearSelected() {
		selectedList.clear();
    }
	
	
	//ClipBoard
	public void addClipBoard(IShape s) {
        clipBoard.add(s);

    }

    public void removeClipBoard() {
        clipBoard.removeAll(selectedList);
    }

    public void clearClipBoard() {
        clipBoard.clear();
    }

    public ArrayList<IShape> getClipBoard() {
        return clipBoard;
    }
	
	public void update()
	{
		System.out.println("update");
		
		g.setColor(Color.WHITE);
    	g.fillRect(0, 0, 500000, 500000);
    	
    	for (IShape s: shapeList)
    	{
			s.makeShape();
		}
    	
    	for (IShape s: selectedList)
    	{
			s.makeSelect();
		}
	}
}
