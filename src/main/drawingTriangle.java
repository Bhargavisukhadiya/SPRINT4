package main;

import model.ShapeColor;
import model.ShapeShadingType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.awt.*;

public class drawingTriangle implements drawingStrategy {
    private int x[];
    private int y[];
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;
    private ShapeColor primary, secondary;
    private ShapeShadingType shading;

    public drawingTriangle(PaintCanvasBase paintCanvas, IApplicationState appState, int[] x, int[] y, ShapeColor primary, ShapeColor secondary, ShapeShadingType shading){
        this.paintCanvas=paintCanvas;
        this.appState=appState;
        this.x=x;
        this.y=y;
        this.primary = primary;
        this.secondary = secondary;
        this.shading=shading;
        if(this.shading.equals(ShapeShadingType.FILLED_IN)) {
            drawFilled();
        }
        if(this.shading.equals(ShapeShadingType.OUTLINE)) {
            drawOutline();
        }
        if(this.shading.equals(ShapeShadingType.OUTLINE_AND_FILLED_IN)) {
            drawOutlineFilled();
        }
    }
    @Override
    public void drawOutline() {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(ShapeColor.getColor(primary));
        graphics2d.drawPolygon(x,y,3);
    }

    @Override
    public void drawFilled() {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(ShapeColor.getColor(primary));
        graphics2d.fillPolygon(x,y,3);
    }

    @Override
    public void drawOutlineFilled() {
        Graphics2D graphics2d = paintCanvas.getGraphics2D();
        graphics2d.setColor(ShapeColor.getColor(primary));
        graphics2d.fillPolygon(x,y,3);
        graphics2d.setStroke(new BasicStroke(5));
        graphics2d.setColor(ShapeColor.getColor(secondary));
        graphics2d.drawPolygon(x,y,3);
    }
}
