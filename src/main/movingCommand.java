package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public class movingCommand implements ICommand, IUndoable{
    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;
    private Point deltaTlBR;//Top left Bottom Right
    private Point deltaBRTL; //Bottom Right Top Left
    private Point deltaBLTR;
    private Point deltaBLTRS;
    private int oldX;
    private int oldY;
    private int oldX1;
    private int oldY1;
    ArrayList<Shaping> moveShaping = new ArrayList<Shaping>();
    ArrayList<Shaping> redo= new ArrayList<Shaping>();
    ArrayList<Integer> x= new ArrayList<Integer>();
    ArrayList<Integer> y= new ArrayList<Integer>();
    ArrayList<Integer> x1= new ArrayList<Integer>();
    ArrayList<Integer> y1= new ArrayList<Integer>();
    public movingCommand(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, IApplicationState appState) {
        this.startPoint=startPoint;
        this.endPoint=endPoint;
        this.paintCanvas=paintCanvas;
        this.appState=appState;
    }

    @Override
    public void run() {
        CommandStory.add(this);
        int oldX;
        int oldY;
        int newX;
        int newY;
        int newX1;
        int newY1;
        Boolean result;
        deltaTlBR=new Point(endPoint.getX()-startPoint.getX(),endPoint.getY()-startPoint.getY());
        deltaBRTL= new Point(startPoint.getX()-endPoint.getX(),startPoint.getY()-endPoint.getY());
        deltaBLTR= new Point(endPoint.getX()-startPoint.getX(),startPoint.getY()-endPoint.getY());
        deltaBLTRS= new Point(startPoint.getX()-endPoint.getX(),endPoint.getY()-startPoint.getY());
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(Color.white);
        graphics2d.fillRect(0 ,0, paintCanvas.getWidth(), paintCanvas.getHeight());
        for(Shaping s:appState.getShapelist()){
            result=s.isPolygon();
            if(startPoint.getX()<endPoint.getX()&&startPoint.getY()<endPoint.getY() && s.isSelected==true){
                if(s.isPolygon()){
                    oldX=s.getX();
                    oldY=s.getY();
                    oldX1=s.getX1();
                    oldY1=s.getY1();
                    x.add(oldX);
                    y.add(oldY);
                    x1.add(oldX1);
                    y1.add(oldY1);
                    s.setMoved(true);
                    moveShaping.add(s);
                    newX=s.getX()+deltaTlBR.getX();
                    newY=s.getY()+deltaTlBR.getY();
                    newX1=s.getX1()+deltaTlBR.getX();
                    newY1=s.getY1()+deltaTlBR.getY();
                    s.setX(newX);
                    s.setY(newY);
                    s.setX1(newX1);
                    s.setY1(newY1);
                    s.setNewX();
                    s.setNewY();
                    s.drawShape();
                    s.selectShape();
                }
                if(s.isEllipse()) {
                    oldX=s.getX();
                    oldY=s.getY();
                    x.add(oldX);
                    y.add(oldY);
                    s.setMoved(true);
                    moveShaping.add(s);
                    newX=s.getX()+deltaTlBR.getX();
                    newY=s.getY()+deltaTlBR.getY();
                    s.setX(newX);
                    s.setY(newY);
                    s.drawShape();
                    s.selectShape();
                }
                if(s.isRectangle()) {
                    oldX=s.getX();
                    oldY=s.getY();
                    x.add(oldX);
                    y.add(oldY);
                    s.setMoved(true);
                    moveShaping.add(s);
                    newX=s.getX()+deltaTlBR.getX();
                    newY=s.getY()+deltaTlBR.getY();
                    s.setX(newX);
                    s.setY(newY);
                    s.drawShape();
                    s.selectShape();
                }
            }
            if(startPoint.getX()>endPoint.getX()&&startPoint.getY()>endPoint.getY()&& s.isSelected==true){
                if(s.isPolygon()){
                    oldX=s.getX();
                    oldY=s.getY();
                    oldX1=s.getX1();
                    oldY1=s.getY1();
                    x.add(oldX);
                    y.add(oldY);
                    x1.add(oldX1);
                    y1.add(oldY1);
                    s.setMoved(true);
                    moveShaping.add(s);
                    newX=s.getX()-deltaBRTL.getX();
                    newY=s.getY()-deltaBRTL.getY();
                    newX1=s.getX1()-deltaBRTL.getX();
                    newY1=s.getY1()-deltaBRTL.getY();
                    s.setX(newX);
                    s.setY(newY);
                    s.setX1(newX1);
                    s.setY1(newY1);
                    s.setNewX();
                    s.setNewY();
                    s.drawShape();
                    s.selectShape();
                }
                if(s.isEllipse()) {
                    oldX=s.getX();
                    oldY=s.getY();
                    x.add(oldX);
                    y.add(oldY);
                    s.setMoved(true);
                    moveShaping.add(s);
                    newX = s.getX() - deltaBRTL.getX();
                    newY = s.getY() - deltaBRTL.getY();
                    s.setX(newX);
                    s.setY(newY);
                    s.drawShape();
                    s.selectShape();
                }
                if(s.isRectangle()) {
                    oldX=s.getX();
                    oldY=s.getY();
                    x.add(oldX);
                    y.add(oldY);
                    s.setMoved(true);
                    moveShaping.add(s);
                    newX=s.getX()+deltaTlBR.getX();
                    newY=s.getY()+deltaTlBR.getY();
                    s.setX(newX);
                    s.setY(newY);
                    s.drawShape();
                    s.selectShape();
                }
            }
            if(endPoint.getX()>startPoint.getX()&&startPoint.getY()>endPoint.getY()&& s.isSelected==true){
                if(s.isPolygon()){
                    oldX=s.getX();
                    oldY=s.getY();
                    oldX1=s.getX1();
                    oldY1=s.getY1();
                    x.add(oldX);
                    y.add(oldY);
                    x1.add(oldX1);
                    y1.add(oldY1);
                    s.setMoved(true);
                    moveShaping.add(s);
                    newX=s.getX()+deltaBLTR.getX();
                    newY=s.getY()-deltaBLTR.getY();
                    newX1=s.getX1()+deltaBLTR.getX();
                    newY1=s.getY1()-deltaBLTR.getY();
                    s.setX(newX);
                    s.setY(newY);
                    s.setX1(newX1);
                    s.setY1(newY1);
                    s.setNewX();
                    s.setNewY();
                    s.drawShape();
                    s.selectShape();
                }
                if(s.isEllipse()) {
                    oldX=s.getX();
                    oldY=s.getY();
                    x.add(oldX);
                    y.add(oldY);
                    s.setMoved(true);
                    moveShaping.add(s);
                    newX = s.getX() + deltaBLTR.getX();
                    newY = s.getY() - deltaBLTR.getY();
                    s.setX(newX);
                    s.setY(newY);
                    s.drawShape();
                    s.selectShape();
                }
                if(s.isRectangle()) {
                    oldX=s.getX();
                    oldY=s.getY();
                    x.add(oldX);
                    y.add(oldY);
                    s.setMoved(true);
                    moveShaping.add(s);
                    newX=s.getX()+deltaTlBR.getX();
                    newY=s.getY()+deltaTlBR.getY();
                    s.setX(newX);
                    s.setY(newY);
                    s.drawShape();
                    s.selectShape();
                }
            }
            if(startPoint.getX()>endPoint.getX()&&endPoint.getY()>startPoint.getY()&& s.isSelected==true){
                if(s.isPolygon()){
                    oldX=s.getX();
                    oldY=s.getY();
                    oldX1=s.getX1();
                    oldY1=s.getY1();
                    x.add(oldX);
                    y.add(oldY);
                    x1.add(oldX1);
                    y1.add(oldY1);
                    s.setMoved(true);
                    moveShaping.add(s);
                    newX=s.getX()-deltaBLTRS.getX();
                    newY=s.getY()+deltaBLTRS.getY();
                    newX1=s.getX1()-deltaBLTRS.getX();
                    newY1=s.getY1()+deltaBLTRS.getY();
                    s.setX(newX);
                    s.setY(newY);
                    s.setX1(newX1);
                    s.setY1(newY1);
                    s.setNewX();
                    s.setNewY();
                    s.drawShape();
                    s.selectShape();
                }
                if(s.isEllipse()) {
                    oldX=s.getX();
                    oldY=s.getY();
                    x.add(oldX);
                    y.add(oldY);
                    s.setMoved(true);
                    moveShaping.add(s);
                    newX = s.getX() - deltaBLTRS.getX();
                    newY = s.getY() + deltaBLTRS.getY();
                    s.setX(newX);
                    s.setY(newY);
                    s.drawShape();
                    s.selectShape();
                }
                if(s.isRectangle()) {
                    oldX=s.getX();
                    oldY=s.getY();
                    x.add(oldX);
                    y.add(oldY);
                    s.setMoved(true);
                    moveShaping.add(s);
                    newX=s.getX()+deltaTlBR.getX();
                    newY=s.getY()+deltaTlBR.getY();
                    s.setX(newX);
                    s.setY(newY);
                    s.drawShape();
                    s.selectShape();
                }
            }
            if(s.isSelected==false){
                s.drawShape();
                s.setMoved(false);
                moveShaping.add(s);
            }
        }
    }
    @Override
    public void undo() {
        int count=0;
        System.out.println("moveCommand");
        Graphics2D graphics2d = paintCanvas.getGraphics2D();// put this crap in a method
        graphics2d.setColor(Color.white);
          graphics2d.fillRect(0 ,0, paintCanvas.getWidth(), paintCanvas.getHeight());
          for(Shaping s: moveShaping){
              if(s.isPolygon()&& s.getMoved()==true){
                  s.setX(x.get(count));
                  s.setY(y.get(count));
                  s.setX1(x1.get(count));
                  s.setY1(y1.get(count));
                  s.setNewX();
                  s.setNewY();
                  s.drawShape();
                  s.selectShape();
                  redo.add(s);
                 count++;
              }
              if(s.isEllipse()&& s.getMoved()==true) {
                  s.setX(x.get(count));
                  s.setY(y.get(count));
                  s.drawShape();
                  s.selectShape();
                  redo.add(s);
                  count++;
              }
              if(s.isRectangle()&& s.getMoved()==true){
                  s.setX(x.get(count));
                  s.setY(y.get(count));
                  s.drawShape();
                  s.selectShape();
                  redo.add(s);
                  count++;
              }
              if(s.getMoved()==false){
                  s.drawShape();
                  redo.add(s);
              }
        }
    }

    @Override
    public void redo() {
        int count=redo.size();
        Graphics2D graphics2d = paintCanvas.getGraphics2D();// put this crap in a method
        graphics2d.setColor(Color.white);
        graphics2d.fillRect(0 ,0, paintCanvas.getWidth(), paintCanvas.getHeight());
        for(Shaping s: redo){
            if(s.isPolygon()&& s.getMoved()==true){
                s.setX(x.get(count));
                s.setY(y.get(count));
                s.setX1(x1.get(count));
                s.setY1(y1.get(count));
                s.setNewX();
                s.setNewY();
                s.drawShape();
                count--;
            }
            if(s.isEllipse()&& s.getMoved()==true) {
                s.setX(x.get(count));
                s.setY(y.get(count));
                s.drawShape();
                count--;
            }
            if(s.isRectangle()&& s.getMoved()==true){
                s.setX(x.get(count));
                s.setY(y.get(count));
                s.drawShape();
                count--;
            }
            if(s.getMoved()==false){
                s.drawShape();
            }
        }
    }
}