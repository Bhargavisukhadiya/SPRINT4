package main;
import model.MouseMode;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class ShapeTheCommand implements ICommand, IUndoable {
    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;

    public ShapeTheCommand(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, IApplicationState appState) {
        this.startPoint=startPoint;
        this.endPoint=endPoint;
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }

    @Override
    public void run() {
        if(appState.getActiveMouseMode().equals(MouseMode.DRAW)) {
            commandingStrategy draw= new drawingCommandingStrategy(startPoint,endPoint,paintCanvas,appState);
            draw.executeCommand();
        }
       if(appState.getActiveMouseMode().equals(MouseMode.SELECT)){
           commandingStrategy select= new selectingCommandingStrategy(startPoint,endPoint,paintCanvas,appState);
           select.executeCommand();
       }
        if(appState.getActiveMouseMode().equals(MouseMode.MOVE)){
            commandingStrategy move= new movingCommandingStrategy(startPoint,endPoint,paintCanvas,appState);
            move.executeCommand();
        }
    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {
    }
}



