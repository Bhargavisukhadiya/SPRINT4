package main;

import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

 class TriangleLoveShaping extends Shaping {
     private int newX[];
     private int newY[];
     private int deltaX[];
     private int deltaY[];
     private int newWidth;
     private int newHeight;
     private Point selectPoint;
     private int x;
     private int y;
     private int x1;
     private int y1;
     private int iD=-10;
     private Boolean isMoved;
     private drawingStrategy drawTriangle;
     private ShapeColor primary,secondary;
     private ShapeShadingType shading;

     public TriangleLoveShaping(Point startPoint, Point endPoint, PaintCanvasBase paintCanvas, IApplicationState appState) {
        this.startPoint=startPoint;
        this.endPoint=endPoint;
        this.paintCanvas=paintCanvas;
        this.appState=appState;
        selectPoint=new Point(Math.min(startPoint.getX(),endPoint.getX()),Math.min(startPoint.getY(),endPoint.getY()));
        x=startPoint.getX();
        y=startPoint.getY();
        x1=endPoint.getX();
        y1=endPoint.getY();
        newWidth= Math.abs(endPoint.getX() - startPoint.getX());
        newHeight=Math.abs(endPoint.getY() - startPoint.getY());
        newX= new int[]{getX(), getX1(),getX()};
        newY=new int[]{getY(),getY1(),getY1()};
        this.primary = appState.getActivePrimaryColor();
        this.secondary = appState.getActiveSecondaryColor();
         this.shading=appState.getActiveShapeShadingType();
    }

     public void drawShape(){
           drawTriangle= new drawingTriangle(paintCanvas,appState,getNewX(),getNewY(),primary,secondary,shading);
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

     public Boolean getMoved(){return isMoved;}

     public void setMoved(Boolean answ){
         isMoved=answ;
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

     public Boolean isPolygon() {
         return true;
     }

     @Override
     public Boolean isRectangle() {
         return false;
     }

     @Override
     public Boolean isEllipse() {
         return false;
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
        int x= getNewX()[0]-10;
        int x1=getNewX()[1]+20;
        int x2=getNewX()[2]-20;
        int y=getNewY()[0]-10;
        int y1=getNewY()[1]+5;
        int y2=getNewY()[2]+10;
        int[]xA=new int []{x,x1,x2};
         int[]yA=new int []{y,y1,y2};

         Graphics2D graphics2d = paintCanvas.getGraphics2D();
         graphics2d.setColor(Color.WHITE);
         graphics2d.fillPolygon(xA,yA,3);

         graphics2d.fillRect(x-10, y-10,getNewWidth()+20,getNewHeight()+20);
    }
     public void selectShape(){
         int x= getNewX()[0]-5;
         int x1=getNewX()[1]+5;
         int x2=getNewX()[2];
         int y=getNewY()[0]-5;
         int y1=getNewY()[1]+5;
         int y2=getNewY()[2];
         int[]xA=new int []{x,x1,x};
         int[]yA=new int []{y,y1,y1};
         Graphics2D graphics2d = paintCanvas.getGraphics2D();
         Stroke stroke = new BasicStroke(3, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 1, new float[]{9}, 0);
         graphics2d.setStroke(stroke);
         graphics2d.setColor(Color.BLACK);
        //graphics2d.drawPolygon(xA,yA,3);
         graphics2d.drawPolygon(getNewX(),getNewY(),3);
     }

     public void setNewX(){ newX= new int[]{getX(), getX1(),getX()};//start ,end, start
     }
     public void setNewY(){
         newY=new int[]{getY(),getY1(),getY1()};//start, end,end
     }
     public void setX(int point){ x=point; }
     public void setY(int point){ y=point; }
     public void setX1(int point){
        x1=point;
     }
     public void setY1(int point){
        y1=point;
     }
     public int getX(){
         return x;
     }
     public int getY(){
         return y;
     }
     public int getX1(){
        return x1;
     }
     public int getY1(){
        return y1;
     }
     public int[] getNewX(){
         return newX;
     }
     public int[] getNewY(){
        return newY;
     }
     @Override
     public int getNewWidth() {
         return newWidth;
     }
     @Override
     public int getNewHeight() {
         return newHeight;
     }
}






















