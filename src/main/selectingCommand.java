package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;
import java.awt.geom.Area;

import java.awt.*;

public  class selectingCommand implements ICommand, IUndoable {
    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;
    private Shaping s;

    public selectingCommand(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, IApplicationState appState) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.paintCanvas = paintCanvas;
        this.appState = appState;
    }

    @Override
    public void run() {
        Point point=new Point(Math.min(startPoint.getX(),endPoint.getX()),Math.min(startPoint.getY(),endPoint.getY()));
        int width= Math.abs(endPoint.getX()-startPoint.getX());
        int height= Math.abs(endPoint.getY()-startPoint.getY());
        Rectangle rect= new Rectangle(point.getX(),point.getY(),width,height);
        Boolean answer;
        for (Shaping s : appState.getShapelist()) {
            Rectangle second= new Rectangle(s.getX(),s.getY(),s.getNewWidth(),s.getNewHeight());
            answer=isCollision(rect,second);
            if(s.groupID()!=-10 && answer==true){
                    for(Shaping j : appState.getShapelist()){
                       if(s.groupID() == j.groupID() && s.groupID()!=-10){
                           j.setSelected(true);
                           j.selectShape();
                       }
                    }
                break;
            }
            if(answer==true ){
                s.selectShape();
                s.setSelected(true);
            }
            if(answer==false){
                s.setSelected(false);
                s.clearShape();
                s.drawShape();
            }
        }
    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {
    }

    public boolean isCollision(Rectangle invisible, Rectangle s){
        Area areaA = new Area( invisible);
        areaA.intersect(new Area(s));
        return !areaA.isEmpty() ;
    }
}
