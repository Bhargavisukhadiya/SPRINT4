package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class drawingCommandingStrategy implements commandingStrategy {
    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;
    private ICommand draw;
    public drawingCommandingStrategy(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, IApplicationState appState) {
        this.startPoint=startPoint;
        this.endPoint=endPoint;
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }
    public void executeCommand() {
        draw= new drawingCommand(startPoint,endPoint,paintCanvas,appState);
        draw.run();
    }
}
