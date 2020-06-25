package controller;

public class RedoCommand implements ShapeCommand {

	@Override
	public void run()
	{
		CommandHistory.redo();
		System.out.println("REDO");
	}

}
