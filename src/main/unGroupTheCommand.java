package main;

import model.interfaces.IApplicationState;

import java.util.ArrayList;

public class unGroupTheCommand implements ICommand,IUndoable {
    private IApplicationState appState;
    private int Id=15;
    public static ArrayList<Shaping> undo = new ArrayList<>();
    public static ArrayList<Shaping> redo = new ArrayList<>();
    private Shaping groupedShape;

    public unGroupTheCommand(IApplicationState appState, Shaping groupedShape) {
        this.appState = appState;
        this.groupedShape=groupedShape;
    }

    @Override
    public void run() {
        CommandStory.add(this);
        for (int i = 0; i < groupedShape.getGroup().size(); i++){
            for(int j=0; j< groupedShape.getGroupList(i).size();j++){
                if(groupedShape.getGroupList(i).get(j).isSelected){
                    groupedShape.getGroupList(i).get(j).setGroupID(-10);
                    undo.add(groupedShape.getGroupList(i).get(j));
                }
            }
        }
    }

    @Override
    public void undo() {
    for(Shaping s: undo){
        s.setGroupID(Id);
        redo.add(s);
    }
    Id++;
    undo.clear();
    System.out.println(Id);
    }

    @Override
    public void redo() {
       for(Shaping j: redo){
           j.setGroupID(-10);
           undo.add(j);
       }
       redo.clear();
    }
}
