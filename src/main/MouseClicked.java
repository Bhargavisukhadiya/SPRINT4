package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class MouseClicked extends MouseAdapter  {
    private Point startPoint;
    private Point endPoint;
    private  PaintCanvasBase paintCanvas;
    private ICommand command;
    private IApplicationState appState;

    MouseClicked(PaintCanvasBase paintCanvas, IApplicationState appState){
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = new Point(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        endPoint= new Point(e.getX(),e.getY());
        command= new ShapeTheCommand(startPoint,endPoint,paintCanvas,appState);
        command.run();
    }
}
