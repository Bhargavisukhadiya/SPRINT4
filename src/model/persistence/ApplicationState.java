package model.persistence;

import main.Shaping;
import model.ShapeColor;
import model.ShapeShadingType;
import model.ShapeType;
import model.MouseMode;
import model.dialogs.DialogProvider;
import model.interfaces.IApplicationState;
import model.interfaces.IDialogProvider;
import view.interfaces.IUiModule;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;


public class ApplicationState extends JPanel implements IApplicationState, Serializable {
    private static final long serialVersionUID = -5545483996576839009L;
    private final IUiModule uiModule;
    private final IDialogProvider dialogProvider;

    private ShapeType activeShapeType;
    private ShapeColor activePrimaryColor;
    private ShapeColor activeSecondaryColor;
    private ShapeShadingType activeShapeShadingType;
    private MouseMode activeMouseMode;
    private  ArrayList<Shaping> shapings = new ArrayList<Shaping>();
    private  ArrayList<Shaping> selected = new ArrayList<Shaping>();
    private  ArrayList<Shaping> copy = new ArrayList<Shaping>();
   // private  ArrayList<Shape> group = new ArrayList<Shape>();
    private ArrayList<ArrayList<Shaping>> group= new ArrayList<>();


    public ApplicationState(IUiModule uiModule) {
        this.uiModule = uiModule;
        this.dialogProvider = new DialogProvider(this);
        setDefaults();
    }

    @Override
    public void setActiveShape() {
        activeShapeType = uiModule.getDialogResponse(dialogProvider.getChooseShapeDialog());
    }

    @Override
    public void setActivePrimaryColor() {
        activePrimaryColor = uiModule.getDialogResponse(dialogProvider.getChoosePrimaryColorDialog());
    }

    @Override
    public void setActiveSecondaryColor() {
        activeSecondaryColor = uiModule.getDialogResponse(dialogProvider.getChooseSecondaryColorDialog());
    }

    @Override
    public void setActiveShadingType() {
        activeShapeShadingType = uiModule.getDialogResponse(dialogProvider.getChooseShadingTypeDialog());
    }

    @Override
    public void setActiveStartAndEndPointMode() {
        activeMouseMode = uiModule.getDialogResponse(dialogProvider.getChooseStartAndEndPointModeDialog());
    }


    public void setShapelist(Shaping shaping){
        shapings.add(shaping);

    }
    public void setGrouplist(ArrayList<Shaping> shaping){
        group.add(shaping);

    }

    public void setSelectedlist(Shaping shaping){
        selected.add(shaping);
    }

    @Override
    public void setCopylist(Shaping shaping) {
        copy.add(shaping);
    }

    public ArrayList<Shaping> getShapelist(){

        return shapings;

    }
    public ArrayList<Shaping> getSelectedlist(){
        return selected;

    }
    public void remove(Shaping s){
           shapings.remove(s);
    }
    public ArrayList<Shaping> getCopyList(){
        return copy;
    }


    public ArrayList<ArrayList<Shaping>> getGroupList() {
        return group;
    }

    public boolean check(Shaping shaping){
        return shapings.contains(shaping);
    }

    public void addShape(Shaping shaping) { shapings.add(shaping); }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shaping shaping : shapings) {
            shaping.draw(g);
        }
    }
    @Override
    public ShapeType getActiveShapeType() {
        return activeShapeType;
    }

    @Override
    public ShapeColor getActivePrimaryColor() {
        return activePrimaryColor;
    }

    @Override
    public ShapeColor getActiveSecondaryColor() {
        return activeSecondaryColor;
    }

    @Override
    public ShapeShadingType getActiveShapeShadingType() {
        return activeShapeShadingType;
    }

    @Override
    public MouseMode getActiveMouseMode() {
        return activeMouseMode;
    }



    private void setDefaults() {
        activeShapeType = ShapeType.ELLIPSE;
        activePrimaryColor = ShapeColor.BLUE;
        activeSecondaryColor = ShapeColor.GREEN;
        activeShapeShadingType = ShapeShadingType.FILLED_IN;
        activeMouseMode = MouseMode.DRAW;
    }
}
