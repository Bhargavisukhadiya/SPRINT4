package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

public class drawingCommand implements ICommand, IUndoable {
    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;
    ArrayList<Shaping> redo= new ArrayList<Shaping>();

    public drawingCommand(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, IApplicationState appState){
        this.startPoint=startPoint;
        this.endPoint=endPoint;
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }
    @Override
    public void run() {
        CommandStory.add(this);
        getShapeGoFactory get = new getShapeGoFactory();
        get.getShape(appState, startPoint, endPoint, paintCanvas);
    }

    @Override
    public void undo() {
        System.out.println("drawCommand");
        appState.getShapelist();
        for(int i=appState.getShapelist().size()-1;i>=0;i--){
            appState.getShapelist().get(i).clearShape();
            redo.add(appState.getShapelist().get(i));
            appState.getShapelist().remove(appState.getShapelist().get(i));
            break;
        }
    }

    @Override
    public void redo() {
       for(Shaping s: redo){
           s.drawShape();
           redo.remove(s);
           appState.getShapelist().add(s);
        }
    }
}
