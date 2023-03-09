package main;

import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;
import java.util.ArrayList;

public abstract class Shaping {
     Point startPoint;
     Point endPoint;
     PaintCanvasBase paintCanvas;
     IApplicationState appState;
     Boolean isPoly;
     Boolean isSelected;
     Boolean isGrouped;
     Graphics2D graphics2d;

     public  void drawShape(){}
     public void setColor(ShapeColor primary, ShapeColor secondary) { }
     public  ShapeColor getPrimaryColor(){return null;}
     public ShapeColor getSecondaryColor() { return null; }
     public Boolean isPolygon() { return null; }
     public Boolean getMoved(){return null;}
     public void setMoved(Boolean answ){}
     public Boolean isRectangle() {
          return null;
     }
     public Boolean isEllipse() {
          return null;
     }
     public void setGroupID(int id) { }
     public int groupID() {
          return 0;
     }
     public void setSelected(Boolean answ) { }
     public Boolean IsSelected() {
          return null;
     }
     public void setShading(ShapeShadingType shade) { }
     public ShapeShadingType getShading() {
          return null;
     }
     public Point getStartPoint() {
          return null;
     }
     public Point getEndPoint() {
          return null;
     }
     public void clearShape() { }
     public void setX(int point) { }
     public void setY(int point) { }
     public void setX1(int point){ }
     public void setY1(int point) { }
     public void setNewX() { }
     public void setNewY() { }
     public int getX() {
          return 0;
     }
     public int getY() {
          return 0;
     }
     public int getX1() {
          return 0;
     }
     public int getY1() {
          return 0;
     }
     public void selectShape() { }
     public int getNewWidth() {
          return 0;
     }
     public int getNewHeight() {
          return 0;
     }
     public  void setShapeList(Shaping shaping){}
     public ArrayList<Shaping> getShapeList(){return null;}
     public  void setGroupList(ArrayList<Shaping> shaping){}
     public  ArrayList<Shaping> getGroupList(int index){return null;}
     public ArrayList<ArrayList<Shaping>> getGroup(){return null;}

     public void draw(Graphics g) {
     }
}
