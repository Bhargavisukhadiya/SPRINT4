package main;

import model.interfaces.IApplicationState;
import view.interfaces.PaintCanvasBase;

import java.util.ArrayList;

public class deleteTheCommand implements ICommand, IUndoable {
    private IApplicationState appState;
    private PaintCanvasBase paintCanvas;
    ArrayList<Shaping> deletedShaping = new ArrayList<Shaping>();
    ArrayList<Shaping> redo= new ArrayList<Shaping>();

    public deleteTheCommand(IApplicationState appState, PaintCanvasBase paintCanvas) {
        this.appState = appState;
        this.paintCanvas=paintCanvas;
    }

    @Override
    public void run() {
        CommandStory.add(this);
        for (Shaping s : appState.getShapelist()) {
            if (s.isSelected) {
                s.clearShape();
                deletedShaping.add(s);
                appState.getShapelist().remove(s);
            }
        }
    }

    @Override
    public void undo() {
        for(int i = deletedShaping.size()-1; i>=0; i++){
            deletedShaping.get(i).drawShape();
            deletedShaping.get(i).selectShape();
            appState.setShapelist(deletedShaping.get(i));
            redo.add(deletedShaping.get(i));
            deletedShaping.remove(deletedShaping.get(i));
        }
    }

    @Override
    public void redo() {
        for(int i=redo.size()-1;i>=0;i++){
            redo.get(i).clearShape();
            redo.remove(redo.get(i));
            deletedShaping.add(redo.get(i));
            appState.getShapelist().remove(redo.get(i));
        }
    }
}

