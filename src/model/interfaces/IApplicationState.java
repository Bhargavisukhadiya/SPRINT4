package model.interfaces;

import main.Shaping;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.MouseMode;

import java.awt.*;
import java.util.ArrayList;

public interface IApplicationState {
    void setActiveShape();

    void setActivePrimaryColor();

    void setActiveSecondaryColor();

    void setActiveShadingType();

    void setActiveStartAndEndPointMode();

    void setShapelist(Shaping shaping);

    void setSelectedlist(Shaping shaping);

    void setCopylist(Shaping shaping);

    void setGrouplist(ArrayList<Shaping> shaping);

    public ArrayList<Shaping> getCopyList();

    public ArrayList<ArrayList<Shaping>> getGroupList();

    public ArrayList<Shaping> getShapelist();

    public ArrayList<Shaping> getSelectedlist();

    public void remove(Shaping s);

    public boolean check(Shaping shaping);

    void paintComponent(Graphics g);

    ShapeType getActiveShapeType();

    ShapeColor getActivePrimaryColor();

    ShapeColor getActiveSecondaryColor();

    ShapeShadingType getActiveShapeShadingType();

    MouseMode getActiveMouseMode();
}
