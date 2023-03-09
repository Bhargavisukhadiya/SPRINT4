package main;

import model.ShapeType;
import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

class getShapeGoFactory {
    private Point startPoint;
    private Point endPoint;
    private PaintCanvasBase paintCanvas;
    private IApplicationState appState;

    public void getShape(IApplicationState appState, Point startPoint, Point endPoint, PaintCanvasBase paintCanvas) {
        if (appState.getActiveShapeType().equals(ShapeType.RECTANGLE)) {
            Shaping shep = new RectangleLoveShaping(startPoint, endPoint, paintCanvas, appState);
            shep.drawShape();
            appState.setShapelist(shep);
        }
        if (appState.getActiveShapeType().equals(ShapeType.ELLIPSE)) {
            Shaping ellipse = new EllipseShaping(startPoint, endPoint, paintCanvas, appState);
            ellipse.drawShape();
            appState.setShapelist(ellipse);
        }
        if (appState.getActiveShapeType().equals(ShapeType.TRIANGLE)) {
            Shaping tri = new TriangleLoveShaping(startPoint, endPoint, paintCanvas, appState);
            tri.drawShape();
            appState.setShapelist(tri);
        }
    }
}
