package main;

import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

 class EllipseShaping extends Shaping {
    private int newWidth;
     private int newHeight;
     private Point selectPoint;
    private  int x;
     private int y;
    private int iD=-10;
    private Boolean isMoved;
     private drawingStrategy drawRect;
   private  ShapeColor primary,secondary;
    private ShapeShadingType shading;

     public EllipseShaping(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, IApplicationState appState) {
         this.startPoint = startPoint;
         this.endPoint = endPoint;
         this.paintCanvas = paintCanvas;
         this.appState = appState;
         newWidth= Math.abs(endPoint.getX() - startPoint.getX());
         newHeight=Math.abs(endPoint.getY() - startPoint.getY());
         selectPoint=new Point(Math.min(startPoint.getX(),endPoint.getX()),Math.min(startPoint.getY(),endPoint.getY()));
         x=selectPoint.getX();
         y=selectPoint.getY();
         this.primary = appState.getActivePrimaryColor();
         this.secondary = appState.getActiveSecondaryColor();
         this.shading=appState.getActiveShapeShadingType();
     }

     public void drawShape() {
         drawRect = new drawingEllipse(paintCanvas, appState, getX(), getY(), getNewWidth(), getNewHeight(), primary, secondary,shading);
     }
     @Override
     public void setColor(ShapeColor primary, ShapeColor secondary) {
         this.primary=primary;
         this.secondary=secondary;
     }

     @Override
     public ShapeColor getPrimaryColor() {
         return primary;
     }

     @Override
     public ShapeColor getSecondaryColor() {
         return secondary;
     }

     @Override
     public void setShading(ShapeShadingType shade) {
         shading=shade;
     }

     @Override
     public ShapeShadingType getShading() {
         return shading;
     }

     public Boolean getMoved(){return isMoved;}

     public void setMoved(Boolean answ){
         isMoved=answ;
     }

     @Override
     public Boolean isPolygon() {
         return false;
     }

     @Override
     public Boolean isRectangle() {
         return false;
     }

     @Override
     public Boolean isEllipse() {
         return true;
     }

     @Override
     public void setGroupID(int id) {
         iD=id;
     }

     @Override
     public int groupID() {
         return iD;
     }

     @Override
     public void setSelected(Boolean answ) {
         isSelected=answ;
     }

     @Override
     public Boolean IsSelected() {
         return isSelected;
     }

     @Override
     public Point getStartPoint() {
         return startPoint;
     }

     @Override
     public Point getEndPoint() {
         return endPoint;
     }

     @Override
     public void clearShape() {
         Graphics2D graphics2d = paintCanvas.getGraphics2D();
         graphics2d.setColor(Color.WHITE);
         graphics2d.fillOval(getX()-10, getY()-10,getNewWidth()+20,getNewHeight()+20);
     }

     @Override
     public void setX(int point) {
         x = point;
     }

     @Override
     public void setY(int point) {
         y=point;
     }

     public void selectShape() {
         Graphics2D graphics2d = paintCanvas.getGraphics2D();
         Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
         graphics2d.setStroke(stroke);
         graphics2d.setColor(Color.BLACK);
         graphics2d.drawOval(getX()-5, getY()-5, getNewWidth()+10, getNewHeight()+10);
     }

     public int getNewWidth() {
         return newWidth;
     }

     public int getNewHeight() {
         return newHeight;
     }

     public int getX() {
         return x;
     }

     public int getY() {
         return y;
     }

     @Override
     public int getX1() {
         return 0;
     }

     @Override
     public int getY1() {
         return 0;
     }
 }

