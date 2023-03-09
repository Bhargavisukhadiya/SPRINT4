package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

public class movingCommandingStrategy implements commandingStrategy {
    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;
    private ICommand move;

    public movingCommandingStrategy(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, IApplicationState appState) {
        this.startPoint=startPoint;
        this.endPoint=endPoint;
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }

    public void executeCommand() {
         move= new movingCommand(startPoint,endPoint,paintCanvas,appState);
        move.run();
    }
}