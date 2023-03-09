package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class pasteTheCommand implements ICommand, IUndoable {
    private IApplicationState appState;
    private PaintCanvasBase paintCanvas;
    ArrayList<Shaping> pastedShaping = new ArrayList<Shaping>();

    public pasteTheCommand(IApplicationState appState, PaintCanvasBase paintCanvas) {
        this.appState = appState;
        this.paintCanvas = paintCanvas;
    }

    @Override
    public void run() {
        CommandStory.add(this);
        for (Shaping s : appState.getCopyList()) {
            int x = Math.abs(s.getX() - s.getX1());
            int y = Math.abs(s.getY() - s.getY1());
            if (s.isPolygon()) {
                TriangleLoveShaping triangle= new TriangleLoveShaping(s.getStartPoint(),s.getEndPoint(),paintCanvas,appState);
                triangle.setColor(s.getPrimaryColor(),s.getSecondaryColor());
                triangle.setShading(s.getShading());
                triangle.setX(s.getX()-30);
                triangle.setY(s.getY()-30);
               triangle.setX1(triangle.getX()+x);
               triangle.setY1( triangle.getY()+y);
                triangle.setNewX();
               triangle.setNewY();
                triangle.drawShape();
                appState.setShapelist(triangle);
                pastedShaping.add(triangle);
            }
           if (s.isRectangle()) {
                Shaping shaping = new RectangleLoveShaping(s.getStartPoint(), s.getEndPoint(), paintCanvas, appState);
                shaping.setColor(s.getPrimaryColor(),s.getSecondaryColor());
                shaping.setShading(s.getShading());
                shaping.setX(s.getX()-30);
                shaping.setY(s.getY()-30);
                shaping.drawShape();
                appState.setShapelist(shaping);
                pastedShaping.add(shaping);
             }
           if(s.isEllipse()){
                Shaping ellipse = new EllipseShaping(s.getStartPoint(), s.getEndPoint(), paintCanvas, appState);
                ellipse.setColor(s.getPrimaryColor(),s.getSecondaryColor());
                ellipse.setShading(s.getShading());
                ellipse.setX(s.getX()-30);
                ellipse.setY(s.getY()-30);
                ellipse.drawShape();
                appState.setShapelist(ellipse);
               pastedShaping.add(ellipse);
           }
        }
    }

    @Override
    public void undo() {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.white);
        graphics2d.fillRect(0, 0, paintCanvas.getWidth(), paintCanvas.getHeight());
        for(Shaping j: pastedShaping){
            appState.getShapelist().remove(j);
        }
        for(Shaping s: appState.getShapelist()){
            s.drawShape();
        }
    }

    @Override
    public void redo() {
        run();
    }
}