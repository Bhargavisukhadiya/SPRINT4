package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class selectingCommandingStrategy implements commandingStrategy {

    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;
    private ICommand select;

    public selectingCommandingStrategy(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, IApplicationState appState) {
        this.startPoint=startPoint;
        this.endPoint=endPoint;
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }

    public void executeCommand() {
        select= new selectingCommand(startPoint,endPoint,paintCanvas,appState);
        select.run();
    }
}
