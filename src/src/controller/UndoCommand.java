package controller;

public class UndoCommand implements ShapeCommand {

	@Override
	public void run()
	{
		CommandHistory.undo();
		System.out.println("UNDO");
	}

}
